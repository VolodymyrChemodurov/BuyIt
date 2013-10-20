package com.epam.lab.buyit.controller.builder;

import java.sql.Timestamp;

import com.epam.lab.buyit.model.Bid;

public class BidBuilder {
	
	public static Bid build(int auctionId, int userId, Timestamp time, double amount) {
		Bid bid = new Bid();
		bid.setTime(time)
		.setAmount(amount)
		.setAuctionId(auctionId)
		.setUserId(userId);
		return bid;
	}
	
	public static Bid build(int auctionId, int userId, double amount) {
		Bid bid = new Bid();
		bid.setTime(new Timestamp(System.currentTimeMillis()))
		.setAmount(amount)
		.setAuctionId(auctionId)
		.setUserId(userId);
		return bid;
	}
}
