package com.learning.cookiestore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.UserVO;

// 예시를 위해 UserDAO만 작성

@Mapper
public interface UserDAO {
	// 유저 생성
	int save(UserVO userVO);

	// 유저 조회
	UserVO findUserByUserId(String userId);

	// 유저 수정
	int updateUserByUserId(UserVO userVO);

	// 유저 삭제
	int deleteUserByUserId(String userId);
	
}
