package com.epam.lab.buyit.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Auction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAuction;
	private int productId;
	private double startPrice;
	private double buyItNow;
	private int count;
	private double currentPrice;
	private String status;
	private Timestamp startTime;
	private Timestamp endTime;

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

	public Timestamp getStartTime() {
		return startTime;
	}

	public Auction setStartTime(Timestamp startTime) {
		this.startTime = startTime;
		return this;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public Auction setEndTime(Timestamp endTime) {
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
