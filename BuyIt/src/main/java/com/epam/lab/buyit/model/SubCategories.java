package com.epam.lab.buyit.model;

public class SubCategories {

	private int idSubCategory;
	private String name;
	private int categoryId;

	public int getIdSubCategory() {
		return idSubCategory;
	}

	public SubCategories setIdSubCategory(int idSubCategory) {
		this.idSubCategory = idSubCategory;
		return this;
	}

	public String getName() {
		return name;
	}

	public SubCategories setName(String name) {
		this.name = name;
		return this;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public SubCategories setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		return this;
	}

}
