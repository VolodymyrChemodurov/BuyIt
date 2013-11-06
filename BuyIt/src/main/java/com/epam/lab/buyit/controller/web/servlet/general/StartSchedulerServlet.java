package com.epam.lab.buyit.controller.web.servlet.general;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import com.epam.lab.buyit.controller.auction.AuctionScheduler;

public class StartSchedulerServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(StartSchedulerServlet.class);
	private static final long serialVersionUID = 1L;
	private static AuctionScheduler auctionScheduler;
	
	@Override
	public void init() throws ServletException {
		try {
			auctionScheduler = AuctionScheduler.getInstance();
			auctionScheduler.run();
		} catch (SchedulerException e) {
			LOGGER.error(e);
		}
	}
	
	@Override
	public void destroy() {
		try {
			auctionScheduler.stop();
		} catch (SchedulerException e) {
			LOGGER.error(e);
		}
	}

}
