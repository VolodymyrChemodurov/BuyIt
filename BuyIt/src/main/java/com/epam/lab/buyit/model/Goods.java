package com.epam.lab.buyit.model;

public class Goods {

	private int idGood;
	private String name;
	private int auctionId;
	private int subCategoryId;
	private int userId;
	private int descriptionId;

	public int getIdGood() {
		return idGood;
	}

	public Goods setIdGood(int idGood) {
		this.idGood = idGood;
		return this;
	}

	public String getName() {
		return name;
	}

	public Goods setName(String name) {
		this.name = name;
		return this;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public Goods setAuctionId(int auctionId) {
		this.auctionId = auctionId;
		return this;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public Goods setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Goods setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public Goods setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
		return this;
	}

}
