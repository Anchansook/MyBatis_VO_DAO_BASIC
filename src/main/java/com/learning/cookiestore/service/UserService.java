package com.learning.cookiestore.service;

import com.learning.cookiestore.exception.ResponseDto;

public interface UserService {
	// 회원가입 - 아이디 중복 확인
	public ResponseDto idCheck(String userId);

	// 회원가입 - 이메일 중복 확인 (정식이라면 인증번호 전송도 해야하지만 일단은 그냥)
	public ResponseDto emailCheck(String email);
	
}
