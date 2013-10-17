package com.epam.lab.buyit.controller.auction.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import com.epam.lab.buyit.controller.auction.job.creator.ServeAuctionJobCreator;
import com.epam.lab.buyit.controller.auction.trigger.creator.DisposableTriggerCreator;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.model.Auction;

public class FindSoonEndingAuctionsJob implements Job {

	private static final Logger LOGGER = Logger
			.getLogger(FindSoonEndingAuctionsJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		long currentTime = System.currentTimeMillis();
		long endTime = arg0.getTrigger().getNextFireTime().getTime();
		AuctionServiceImp auctionService = new AuctionServiceImp();

		List<Auction> soonEndingAuctions = auctionService
				.getSoonEndingAuctions(currentTime, endTime);

		Scheduler scheduler = arg0.getScheduler();

		for (Auction currentAuction : soonEndingAuctions) {
			DisposableTriggerCreator creatorDisposable = new DisposableTriggerCreator();
			ServeAuctionJobCreator serveAuctionJobCreator = new ServeAuctionJobCreator();
			Trigger trigger = creatorDisposable.create(currentAuction
					.getEndTime().getTime());
			trigger.getJobDataMap().put("auctionId",
					currentAuction.getIdAuction());
			try {
				scheduler.scheduleJob(serveAuctionJobCreator.create(), trigger);
				LOGGER.info("get soon auction");
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
	}
}
