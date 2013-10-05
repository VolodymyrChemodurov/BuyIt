package com.epam.lab.buyit.model;

import java.util.List;

public class Description {
	private int productId;
	private int idDescription;
	private String features;
	private String descText;
	private List<Image> itemPhotos;

	public int getIdDescription() {
		return idDescription;
	}

	public Description setIdDescription(int idDescription) {
		this.idDescription = idDescription;
		return this;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idDescription).append(" features: ").append(features)
				.append(" description: ").append(descText).append(itemPhotos);
		return string.toString();
	}

}
