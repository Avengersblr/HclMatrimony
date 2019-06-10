package com.matrimony.exception;

public class MatrimonyApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MatrimonyApplicationException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

	public MatrimonyApplicationException(String errorMessage) {
		super(errorMessage);
	}
	
	
}
