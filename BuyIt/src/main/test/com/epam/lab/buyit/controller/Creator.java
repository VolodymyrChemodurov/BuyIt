package com.epam.lab.buyit.controller;

import java.sql.Timestamp;

import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Category;

public class Creator {

	private AuctionDAO auctionDAO = null;
	private CategoryDAO categoryDAO = null;

	public Creator() {
		auctionDAO = new AuctionDAO();
		categoryDAO = new CategoryDAO();
	}

	public int createAuction() {
		Auction auction = new Auction();
		long oneWeek = 7 * 24 * 60 * 60 * 1000;
		auction.setBuyItNow(400)
				.setCount(5)
				.setCurrentPrice(50)
				.setEndTime(new Timestamp(System.currentTimeMillis() + oneWeek))
				.setProductId(33).setStartPrice(1)
				.setStartTime(new Timestamp(System.currentTimeMillis()))
				.setStatus("inProgress");

		return auctionDAO.createElement(auction);
	}

	public int createCategory() {
		Category category = new Category();
		category.setName("Test");
		return categoryDAO.createElement(category);
	}
}
