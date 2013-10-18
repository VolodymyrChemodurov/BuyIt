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

	public String getPath() {
		return path;
	}

	public Image setPath(String path) {
		this.path = path;
		return this;
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(descriptionId).append(" path: ").append(path);
		return string.toString();
	}

}
