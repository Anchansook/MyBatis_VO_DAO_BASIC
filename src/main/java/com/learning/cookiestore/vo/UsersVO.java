package com.learning.cookiestore.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//# 데이터를 담는 객체 - 유저

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersVO {
	private String userId;
	private String password;
	private String name;
	private String email;
	
}

//# 현재
// : VO는 불변 객체로 설계하는 것이 표준이며, 
//   생성자를 사용해 초기값을 설정하며 Setter는 제거하는 방식이 권장

//# 옛날
// : 생성자 없음. 
//   아마 DTO처럼 활용한 듯
