package com.epam.lab.buyit.model;

public class Product {

	private int idProduct;
	private int subCategoryId;
	private int userId;
	private String name;
	private Description description;

	public Product() {
		description = new Description();
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
}
