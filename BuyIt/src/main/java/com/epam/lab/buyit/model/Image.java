package com.epam.lab.buyit.model;

public class Image {

	private int idImage;
	private int descriptionId;
	private String path;

	public int getIdImage() {
		return idImage;
	}

	public Image setIdImage(int idImage) {
		this.idImage = idImage;
		return this;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public Image setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
		return this;
	}

	public String getPath() {
		return path;
	}

	public Image setPath(String path) {
		this.path = path;
		return this;
	}

}
