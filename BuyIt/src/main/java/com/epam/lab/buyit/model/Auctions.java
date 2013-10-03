package com.epam.lab.buyit.model;

import java.sql.Time;

public class Auctions {

	private int idAuction;
	private double startPrice;
	private Time startTime;
	private Time endTime;
	private String status;
	private double buyItNow;
	private int count;
	private int productId;
	private double currentPrice;

	public int getIdAuction() {
		return idAuction;
	}

	public Auctions setIdAuction(int idAuction) {
		this.idAuction = idAuction;
		return this;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public Auctions setStartPrice(double startPrice) {
		this.startPrice = startPrice;
		return this;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Auctions setStartTime(Time startTime) {
		this.startTime = startTime;
		return this;
	}

	public Time getEndTime() {
		return endTime;
	}

	public Auctions setEndTime(Time endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Auctions setStatus(String status) {
		this.status = status;
		return this;
	}

	public double getBuyItNow() {
		return buyItNow;
	}

	public Auctions setBuyItNow(double buyItNow) {
		this.buyItNow = buyItNow;
		return this;
	}

	public int getCount() {
		return count;
	}

	public Auctions setCount(int count) {
		this.count = count;
		return this;
	}

	public int getProductId() {
		return productId;
	}

	public Auctions setProductId(int productId) {
		this.productId = productId;
		return this;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public Auctions setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
		return this;
	}

}
