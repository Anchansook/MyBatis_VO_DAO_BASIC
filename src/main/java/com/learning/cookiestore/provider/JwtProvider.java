package com.learning.cookiestore.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

//# class: JWT 생성 및 검증 기능 제공자

@Component
public class JwtProvider {
	@Value("${jwt.secret}")
	private String secretKey;

	// JWT 생성 메서드
	public String create(String userId) {
		// 만료 시간 = 현재 시간 + 10시간
		Date expiredDate = Date.from(Instant.now().plus(10, ChronoUnit.HOURS));

		String jwt = null;

		try {
			// JWT 암호화에 사용할 Key 생성
			Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

			// JWT 생성
			jwt = Jwts.builder()
				.signWith(key, SignatureAlgorithm.HS256)
				.setSubject(userId)
				.setIssuedAt(new Date())
				.setExpiration(expiredDate)
				.compact();

		} catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}

		return jwt;
	}

	// 검증 메서드
	public String validate(String jwt) {
		String userId = null;

		try {
			// JWT 검증에 사용할 Key 생성
			Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

			// JWT 검증 및 payload의 subject 값 추출
			userId = Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(jwt)
				.getBody()
				.getSubject();

		} catch(Exception exception) {
			exception.printStackTrace();
			return null;
		}
		
		return userId;

	}
	
}
