package com.learning.cookiestore.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.learning.cookiestore.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//# JWT 검증 및 Security Context에 접근 제어자 추가 필터

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private final JwtProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			// Request 객체에서 Bearer 토큰 추출
			String token = parseBearerToken(request);
			if (token == null) {
				// 다음 필터로 제어를 넘긴 후 종료
				// "요청에 JWT 토큰이 없다면, 이 필터는 할 일이 없으니 다음 필터로 넘어간다."
				filterChain.doFilter(request, response);
				return;
			}

			// 토큰 검증
			String userId = jwtProvider.validate(token);
			if (userId == null) {
				filterChain.doFilter(request, response);
				return;
			}

			// security context에 등록

		} catch(Exception exception) {
			exception.printStackTrace();
		}

		filterChain.doFilter(request, response);
	}

	// request로부터 토큰 추출
	private String parseBearerToken(HttpServletRequest request) {
		// Request 객체의 Header에서 Authorization 필드 값을 추출
		String authorization = request.getHeader("Authorization");

		boolean hasAuthorization = StringUtils.hasText(authorization);
		if (!hasAuthorization) return null;

		boolean isBearer = authorization.startsWith("Bearer ");
		if (!isBearer) return null;

		String token = authorization.substring(7);
		return token;

	}

	// security context 생성 및 등록
	private void setContext(HttpServletRequest request, String userId) {
		// 접근 주체에 대한 인증 토큰 생성
		AbstractAuthenticationToken authenticationToken = 
			new UsernamePasswordAuthenticationToken(userId, null, AuthorityUtils.NO_AUTHORITIES);

	}
	
}
