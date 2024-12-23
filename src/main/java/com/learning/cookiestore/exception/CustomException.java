package com.learning.cookiestore.exception;

//# CustomException 사용하기 위한 클래스

public class CustomException extends RuntimeException {
	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
