package com.epam.lab.buyit.model;

public class Images {

	private int idImage;
	private int descriptionId;
	private String path;

	public int getIdImage() {
		return idImage;
	}

	public Images setIdImage(int idImage) {
		this.idImage = idImage;
		return this;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public Images setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
		return this;
	}

	public String getPath() {
		return path;
	}

	public Images setPath(String path) {
		this.path = path;
		return this;
	}

}
