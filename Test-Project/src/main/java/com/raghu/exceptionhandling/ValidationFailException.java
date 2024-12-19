package com.raghu.exceptionhandling;

public class ValidationFailException extends RuntimeException {
	
	

	private static final long serialVersionUID = 1L;

	public ValidationFailException(String message) {
		super(message);

	}

}
