package com.epam.lab.buyit.model;

import java.util.List;

public class Description {

	private int idDescription;
	private List<Image> itemPhotos;
	private String features;
	private String descText;

	public int getIdDescription() {
		return idDescription;
	}

	public Description setIdDescription(int idDescription) {
		this.idDescription = idDescription;
		return this;
	}

	public List<Image> getItemPhotos() {
		return itemPhotos;
	}

	public Description setItemPhotos(List<Image> itemPhotos) {
		this.itemPhotos = itemPhotos;
		return this;
	}

	public void setItemPhoto(Image image) {
		getItemPhotos().add(image);
	}

	public String getFeatures() {
		return features;
	}

	public Description setFeatures(String features) {
		this.features = features;
		return this;
	}

	public String getDescText() {
		return descText;
	}

	public Description setDescText(String descText) {
		this.descText = descText;
		return this;
	}

}
