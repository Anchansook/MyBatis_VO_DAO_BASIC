package com.learning.cookiestore.exception;

//# CustomException 사용하기 위한 클래스

public class CustomException extends RuntimeException {
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getMessage() {
		return message;
	}
	
}
