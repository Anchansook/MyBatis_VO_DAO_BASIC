package com.learning.cookiestore.exception;

import lombok.Getter;
import lombok.Setter;

//# ResponseDto 응답 클래스

@Getter
@Setter
public class ResponseDto {
	private String message;
	private boolean success;

	public ResponseDto(String message, boolean success) {
		this.message = message;
		this.success = success;
	}

	// 성공 메시지 반환 메서드
	public static ResponseDto success(String message) {
		return new ResponseDto(message, true);
	}

	// 실패 메시지 반환 메서드
	public static ResponseDto failure(String message) {
		return new ResponseDto(message, false);
	}
	
}
