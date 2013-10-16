package com.epam.lab.buyit.controller.auction;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.epam.lab.buyit.controller.auction.job.creator.FindSoonEndingAuctionsJobCreator;
import com.epam.lab.buyit.controller.auction.trigger.creator.PeriodicalTriggerCreator;

public class AuctionScheduler {

	public void run() throws SchedulerException {

		SchedulerFactory schedFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedFactory.getScheduler();
		scheduler.start();

		PeriodicalTriggerCreator periodicalTriggerCreator = new PeriodicalTriggerCreator();
		FindSoonEndingAuctionsJobCreator soonEndingAuctionsJobCreator = new FindSoonEndingAuctionsJobCreator();

		scheduler.scheduleJob(soonEndingAuctionsJobCreator.create(),
				periodicalTriggerCreator.create(360));
	}
}
