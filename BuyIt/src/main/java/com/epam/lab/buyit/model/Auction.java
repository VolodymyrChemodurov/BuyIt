package com.epam.lab.buyit.model;

import java.sql.Time;

public class Auction {

	private int idAuction;
	private double startPrice;
	private double buyItNow;
	private int count;
	private double currentPrice;
	private String status;
	private Time startTime;
	private Time endTime;
	private Product product;

	public int getIdAuction() {
		return idAuction;
	}

	public Auction setIdAuction(int idAuction) {
		this.idAuction = idAuction;
		return this;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public Auction setStartPrice(double startPrice) {
		this.startPrice = startPrice;
		return this;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Auction setStartTime(Time startTime) {
		this.startTime = startTime;
		return this;
	}

	public Time getEndTime() {
		return endTime;
	}

	public Auction setEndTime(Time endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Auction setStatus(String status) {
		this.status = status;
		return this;
	}

	public double getBuyItNow() {
		return buyItNow;
	}

	public Auction setBuyItNow(double buyItNow) {
		this.buyItNow = buyItNow;
		return this;
	}

	public int getCount() {
		return count;
	}

	public Auction setCount(int count) {
		this.count = count;
		return this;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public Auction setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idAuction).append(" start price: ").append(startPrice)
				.append(" start time: ").append(startTime)
				.append(" end time: ").append(endTime).append(" status: ")
				.append(status).append(" buy now: ").append(buyItNow)
				.append(" count: ").append(count).append(" curr. price: ")
				.append(currentPrice);
		return string.toString();
	}

}
