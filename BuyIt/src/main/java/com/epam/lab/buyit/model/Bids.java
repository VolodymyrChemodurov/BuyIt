package com.epam.lab.buyit.model;

import java.sql.Time;

public class Bids {

	private int idBid;
	private Time time;
	private int auctionId;
	private int userId;

	public int getIdBid() {
		return idBid;
	}

	public Bids setIdBid(int idBid) {
		this.idBid = idBid;
		return this;
	}

	public Time getTime() {
		return time;
	}

	public Bids setTime(Time time) {
		this.time = time;
		return this;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public Bids setAuctionId(int auctionId) {
		this.auctionId = auctionId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Bids setUserId(int userId) {
		this.userId = userId;
		return this;
	}

}
