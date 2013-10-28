package com.epam.lab.buyit.model;

import java.io.Serializable;

public class Rating implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int fromId;
	private int userId;
	private int rating;
	
	public int getId() {
		return id;
	}
	
	public Rating setId(int id) {
		this.id = id;
		return this;
	}
	
	public int getFromId() {
		return fromId;
	}
	
	public Rating setFromId(int fromId) {
		this.fromId = fromId;
		return this;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public Rating setUserId(int userId) {
		this.userId = userId;
		return this;
	}
	
	public int getRating() {
		return rating;
	}
	
	public Rating setRating(int rating) {
		this.rating = rating;
		return this;
	}
	
}
