package com.epam.lab.buyit.model;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idProduct;
	private String name;
	private int subCategoryId;
	private int userId;
	private String delivery;
	private Description description;
	private Auction auction;

	public Product() {
		description = new Description();
		auction = new Auction();
	}

	public int getIdProduct() {
		return idProduct;
	}

	public Product setIdProduct(int idGood) {
		this.idProduct = idGood;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public Product setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Product setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getDelivery() {
		return delivery;
	}

	public Product setDelivery(String delivery) {
		this.delivery = delivery;
		return this;
	}

	public Description getDescription() {
		return description;
	}

	public Product setDescription(Description description) {
		this.description = description;
		return this;
	}

	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idProduct).append(" name: ").append(name);
		return string.toString();
	}

	public Auction getAuction() {
		return auction;
	}

	public Product setAuction(Auction auction) {
		this.auction = auction;
		return this;
	}

}
