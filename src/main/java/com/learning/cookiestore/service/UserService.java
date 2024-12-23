package com.learning.cookiestore.service;

import com.learning.cookiestore.vo.UsersVO;

public interface UserService {
	// 회원가입 - 아이디 중복 확인
	public boolean idCheck(UsersVO userId);
	
}
