package com.learning.cookiestore.service;

public interface UserService {
	// 회원가입 - 아이디 중복 확인
	public boolean idCheck(String userId);
	
}
