package com.epam.lab.buyit.controller.auction.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;

public class ServeAuctionJob implements Job {

	private static final Logger LOGGER = Logger
			.getLogger(ServeAuctionJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		int auctionId = (int) arg0.getTrigger().getJobDataMap()
				.get("auctionId");
		AuctionServiceImp auctionService = new AuctionServiceImp();
		LOGGER.info("Serving auction with id = " + auctionId);
		if (auctionService.getItemById(auctionId).getStatus().equals("inProgress")) {
			auctionService.closeAuction(auctionId);
			LOGGER.info("Serve auction with id = " + auctionId);
		}
	}

}