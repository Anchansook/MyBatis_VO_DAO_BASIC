package com.learning.cookiestore.service;

import com.learning.cookiestore.exception.ResponseDto;

public interface UserService {
	// 회원가입 - 아이디 중복 확인
	public ResponseDto idCheck(String userId);
	
}
