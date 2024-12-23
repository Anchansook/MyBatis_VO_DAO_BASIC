package com.learning.cookiestore.service.implement;

import org.springframework.stereotype.Service;

import com.learning.cookiestore.exception.CustomException;
import com.learning.cookiestore.service.UserService;
import com.learning.cookiestore.vo.UsersVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
	private final UsersVO usersVO;

	// 회원가입 - 아이디 중복 확인
	@Override
	public boolean idCheck(UsersVO userId) {
		String id = usersVO.getUserId();

		try {
			boolean isExistedId = 

		} catch(Exception exception) {
			exception.printStackTrace();
			throw new CustomException("아이디 중복 확인 중 오류가 발생했습니다.", exception);
		}
	}
	
}
