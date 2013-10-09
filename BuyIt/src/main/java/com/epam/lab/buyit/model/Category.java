package com.epam.lab.buyit.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private int idCategory;
	private String name;
	private List<SubCategory> listSubCategories;

	public Category() {
		listSubCategories = new ArrayList<SubCategory>();
	}
	
	public int getIdCategory() {
		return idCategory;
	}

	public Category setIdCategory(int idCategory) {
		this.idCategory = idCategory;
		return this;
	}

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public List<SubCategory> getListSubCategories() {
		return listSubCategories;
	}

	public void setListSubCategories(List<SubCategory> listSubCategories) {
		this.listSubCategories = listSubCategories;
	}

	public SubCategory getSubCutegory(int index) {
		return getListSubCategories().get(index);
	}

	public void setSubCategory(SubCategory subCategory) {
		getListSubCategories().add(subCategory);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idCategory).append(" name: ").append(name);
		return string.toString();
	}
}
