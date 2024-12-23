package com.learning.cookiestore.dao;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.UsersVO;

// 예시를 위해 UserDAO만 작성

@Mapper
public interface UsersDAO {
	// 유저 생성
	int save(UsersVO userVO);

	// 유저 조회
	UsersVO findUserByUserId(String userId);

	// 유저 수정
	int updateUserByUserId(UsersVO userVO);

	// 유저 삭제
	int deleteUserByUserId(String userId);
	
}
