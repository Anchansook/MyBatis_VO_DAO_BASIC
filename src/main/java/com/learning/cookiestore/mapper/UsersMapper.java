package com.learning.cookiestore.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.learning.cookiestore.vo.UsersVO;

// - 간단하게 사용할거면 Mapper interface만 작성해서 호출해서 사용
// - 대규모라던지 확장, 유지보수가 필요하다면 DAO를 먼저 작성 후
//   Mapper에서 extends로 확장해서 사용

@Mapper
public interface UsersMapper {
	// 유저 생성 (회원가입)
	int save(UsersVO usersVO);

	// 유저 조회
	UsersVO findUserByUserId(String userId);

	// 유저 수정 (기본 수정)
	int updateUserInfoByUserId(UsersVO usersVO);

	// 유저 수정 (비밀번호)
	int updateUserPasswordByUserId(UsersVO usersVO);

	// 유저 삭제
	int deleteUserByUserId(String userId);

	// 회원가입 - 아이디 중복 확인
	boolean existsByUserId(String userId);

	// 회원가입 - 이메일 중복 확인
	boolean existsByEmail(String email);
	
}

//# 확장해서 사용할 경우
// public interface UserMapper extends UserDAO {
	
// }
