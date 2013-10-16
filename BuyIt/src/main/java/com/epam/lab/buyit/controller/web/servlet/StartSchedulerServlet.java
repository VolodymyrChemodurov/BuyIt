package com.epam.lab.buyit.controller.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.quartz.SchedulerException;

import com.epam.lab.buyit.controller.auction.AuctionScheduler;

public class StartSchedulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		AuctionScheduler auctionScheduler = new AuctionScheduler();
		try {
			auctionScheduler.run();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
