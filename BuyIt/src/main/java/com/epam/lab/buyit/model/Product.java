package com.epam.lab.buyit.model;

public class Product {

	private int idGood;
	private String name;
	private int auctionId;
	private int subCategoryId;
	private int userId;
	private Description description;

	public int getIdGood() {
		return idGood;
	}

	public Product setIdGood(int idGood) {
		this.idGood = idGood;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public Product setAuctionId(int auctionId) {
		this.auctionId = auctionId;
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

	public Description getDescription() {
		return description;
	}

	public Product setDescription(Description description) {
		this.description = description;
		return this;
	}

}
