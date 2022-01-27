package com.java.exceptions;

public class InvalidRequestBodyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public InvalidRequestBodyException(String message) {
		super(message);
	}

}
