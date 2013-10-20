package com.epam.lab.buyit.controller.exception;

public class AuctionAllreadyClosedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuctionAllreadyClosedException(String message) {
		super(message);
	}
}
