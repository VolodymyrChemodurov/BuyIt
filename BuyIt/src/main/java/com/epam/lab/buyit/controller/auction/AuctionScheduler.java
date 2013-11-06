package com.epam.lab.buyit.controller.auction;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.epam.lab.buyit.controller.auction.job.creator.FindSoonEndingAuctionsJobCreator;
import com.epam.lab.buyit.controller.auction.trigger.creator.PeriodicalTriggerCreator;

public class AuctionScheduler {
	private static final Logger LOGGER = Logger.getLogger(AuctionScheduler.class);
	private static AuctionScheduler auctionScheduler;
	private static Scheduler scheduler;
	private static boolean singletoneFlag = true;
	
	private AuctionScheduler() {
		LOGGER.info("Creating new instance of AuctionScheduler");
	}
	
	public static AuctionScheduler getInstance() throws SchedulerException {
		if(singletoneFlag) {
			auctionScheduler = new AuctionScheduler();
			LOGGER.info("Creating Scheduler...");
			SchedulerFactory schedFactory = new StdSchedulerFactory();
			scheduler = schedFactory.getScheduler();
			LOGGER.info("Scheduler is created.");
			singletoneFlag = false;
		}
		return auctionScheduler;
	}
	
	public void run() throws SchedulerException {
		LOGGER.info("Starting AuctionScheduler...");
		scheduler.start();
		LOGGER.info("AuctionScheduler running...");
		
		PeriodicalTriggerCreator periodicalTriggerCreator = new PeriodicalTriggerCreator();
		FindSoonEndingAuctionsJobCreator soonEndingAuctionsJobCreator = new FindSoonEndingAuctionsJobCreator();

		scheduler.scheduleJob(soonEndingAuctionsJobCreator.create(),
				periodicalTriggerCreator.create(360));
	}
	
	public void stop() throws SchedulerException {
		LOGGER.info("Stopping AuctionScheduler...");
		scheduler.shutdown(true);
		LOGGER.info("AuctionScheduler is stopped.");
	}
}
