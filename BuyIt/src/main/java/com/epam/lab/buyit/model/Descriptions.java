package com.epam.lab.buyit.model;

public class Descriptions {

	private int idDescription;
	private int itemPhotosId;
	private String features;
	private String descText;

	public int getIdDescription() {
		return idDescription;
	}

	public Descriptions setIdDescription(int idDescription) {
		this.idDescription = idDescription;
		return this;
	}

	public int getItemPhotosId() {
		return itemPhotosId;
	}

	public Descriptions setItemPhotosId(int itemPhotosId) {
		this.itemPhotosId = itemPhotosId;
		return this;
	}

	public String getFeatures() {
		return features;
	}

	public Descriptions setFeatures(String features) {
		this.features = features;
		return this;
	}

	public String getDescText() {
		return descText;
	}

	public Descriptions setDescText(String descText) {
		this.descText = descText;
		return this;
	}

}
