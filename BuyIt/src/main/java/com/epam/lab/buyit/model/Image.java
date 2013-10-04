package com.epam.lab.buyit.model;

public class Image {

	private int idImage;
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

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idImage).append(" path: ").append(path);
		return string.toString();
	}
}
