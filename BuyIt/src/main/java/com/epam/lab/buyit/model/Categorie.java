package com.epam.lab.buyit.model;

import java.util.List;

import com.epam.lab.buyit.model.SubCategory;

public class Categorie {

	private int idCategory;
	private String name;
	private List<SubCategory> listSubCategories;

	public int getIdCategory() {
		return idCategory;
	}

	public Categorie setIdCategory(int idCategory) {
		this.idCategory = idCategory;
		return this;
	}

	public String getName() {
		return name;
	}

	public Categorie setName(String name) {
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
}
