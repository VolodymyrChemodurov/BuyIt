package com.epam.lab.buyit.model;

import java.io.Serializable;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMessage;
	private String message;
	private int fromUserId;
	private int toUserId;

	public int getIdMessage() {
		return idMessage;
	}

	public Message setIdMessage(int idMessage) {
		this.idMessage = idMessage;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Message setMessage(String message) {
		this.message = message;
		return this;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public Message setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
		return this;
	}

	public int getToUserId() {
		return toUserId;
	}

	public Message setToUserId(int toUserId) {
		this.toUserId = toUserId;
		return this;
	}

}
