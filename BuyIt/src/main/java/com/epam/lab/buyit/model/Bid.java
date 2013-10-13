package com.epam.lab.buyit.model;

import java.sql.Timestamp;

public class Bid {

	private int idBid;
	private int auctionId;
	private int userId;
	private Timestamp time;
	private double amount;

	public double getAmount() {
		return amount;
	}

	public Bid setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public int getIdBid() {
		return idBid;
	}

	public Bid setIdBid(int idBid) {
		this.idBid = idBid;
		return this;
	}

	public Timestamp getTime() {
		return time;
	}

	public Bid setTime(Timestamp time) {
		this.time = time;
		return this;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public Bid setAuctionId(int auctionId) {
		this.auctionId = auctionId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Bid setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idBid).append(" time: ").append(time)
				.append(" auction id: ").append(auctionId).append(" amount: ").append(amount).append(" user id: ")
				.append(userId);
		return string.toString();
	}

}
