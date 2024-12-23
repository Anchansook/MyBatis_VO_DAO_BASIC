package com.learning.cookiestore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.cookiestore.exception.ResponseDto;
import com.learning.cookiestore.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	// 회원가입 - 아이디 중복 확인
	@PostMapping("/id-check")
	public ResponseDto idCheck(
		@RequestBody String userId // @Valid는 불필요
	) {
		ResponseDto response = userService.idCheck(userId);
		return response;
	}

	// 회원가입 - 이메일 중복 확인
	@PostMapping("/email-check")
	public ResponseDto emailCheck(
		@RequestBody String email
	) {
		ResponseDto response = userService.emailCheck(email);
		return response;
	}
	
}
