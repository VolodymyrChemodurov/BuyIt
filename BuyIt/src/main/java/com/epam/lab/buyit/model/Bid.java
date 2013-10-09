package com.epam.lab.buyit.model;

import java.sql.Time;

public class Bid {

	private int idBid;
	private int auctionId;
	private int userId;
	private Time time;

	public int getIdBid() {
		return idBid;
	}

	public Bid setIdBid(int idBid) {
		this.idBid = idBid;
		return this;
	}

	public Time getTime() {
		return time;
	}

	public Bid setTime(Time time) {
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
				.append(" auction id: ").append(auctionId).append(" user id: ")
				.append(userId);
		return string.toString();
	}

}
