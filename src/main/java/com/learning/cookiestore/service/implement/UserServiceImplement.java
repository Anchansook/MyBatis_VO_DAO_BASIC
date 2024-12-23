package com.learning.cookiestore.service.implement;

import org.springframework.stereotype.Service;

import com.learning.cookiestore.exception.CustomException;
import com.learning.cookiestore.exception.ResponseDto;
import com.learning.cookiestore.mapper.UsersMapper;
import com.learning.cookiestore.service.UserService;
import com.learning.cookiestore.vo.UsersVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
	private final UsersMapper usersMapper;

	// 회원가입 - 아이디 중복 확인
	@Override
	public ResponseDto idCheck(String userId) {
		try {
			boolean isExistedId = usersMapper.existsByUserId(userId);
			if (isExistedId) throw new CustomException("중복된 아이디입니다.");

		} catch(Exception exception) {
			exception.printStackTrace();
			throw new CustomException("아이디 중복 확인 중 오류가 발생했습니다.", exception);
		}

		return ResponseDto.success("사용 가능한 아이디입니다.");
	}

	// 회원가입 - 이메일 중복 확인
	@Override
	public ResponseDto emailCheck(String email) {
		try {
			boolean isExistedEmail = usersMapper.existsByEmail(email);
			if(isExistedEmail) throw new CustomException("중복된 이메일입니다."); 

		} catch(Exception exception) {
			exception.printStackTrace();
			throw new CustomException("이메일 중복 확인 중 오류가 발생했습니다.", exception);
		}

		return ResponseDto.success("사용 가능한 이메일입니다.");
	}

}
