package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.UserVO;

@Mapper
public interface UserMapper {
	// 유저 생성
	int save(UserVO userVO);

	// 유저 조회
	UserVO findUserByUserId(String userId);

	// 유저 수정
	int updateUserByUserId(UserVO userVO);

	// 유저 삭제
	int deleteUserByUserId(String userId);
	
}
