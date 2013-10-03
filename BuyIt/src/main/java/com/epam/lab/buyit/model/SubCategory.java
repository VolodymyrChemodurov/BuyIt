package com.epam.lab.buyit.model;

public class SubCategory {

	private int idSubCategory;
	private String name;
	private int categoryId;

	public int getIdSubCategory() {
		return idSubCategory;
	}

	public SubCategory setIdSubCategory(int idSubCategory) {
		this.idSubCategory = idSubCategory;
		return this;
	}

	public String getName() {
		return name;
	}

	public SubCategory setName(String name) {
		this.name = name;
		return this;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public SubCategory setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		return this;
	}

}
