package com.epam.lab.buyit.model;

import java.util.List;

public class SubCategory {

	private int idSubCategory;
	private String name;
	private List<Product> products;
	

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idSubCategory).append(" name: ").append(name);
		return string.toString();
	}
}
