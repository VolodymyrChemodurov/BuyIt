package com.epam.lab.buyit.controller.exception;

public class WrongProductCountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongProductCountException(String message) {
		super(message);
	}

}
