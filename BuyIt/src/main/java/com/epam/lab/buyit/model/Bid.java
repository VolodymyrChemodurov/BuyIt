package com.epam.lab.buyit.model;

import java.sql.Time;

public class Bid {

	private int idBid;
	private Time time;
	private int auctionId;
	private int userId;

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

}
