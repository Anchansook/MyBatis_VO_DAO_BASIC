package com.learning.cookiestore.config;

import java.io.IOException;

import org.mybatis.spring.boot.autoconfigure.MybatisProperties.CoreConfiguration;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.learning.cookiestore.exception.CustomException;
import com.learning.cookiestore.filter.JwtAuthenticationFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

//# Spring Web 보안 설정

@Configurable
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
		security
			// basic 인증 방식 미사용
			.httpBasic(HttpBasicConfigurer::disable)
			// session 미사용 (세션 유지 X)
			.sessionManagement(sessionManagement -> sessionManagement
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			// CSRF 취약점 대비 미지정
			.csrf(CsrfConfigurer::disable)
			// CORS 정책 설정
			.cors(cors -> cors.configurationSource(configurationSource()))
			// URL 패턴 및 HTTP 메서드에 따라 인증 및 인가 여부 지정
			.authorizeHttpRequests(request -> request
				.requestMatchers("/api/v1/users/**", "/").permitAll()
				.anyRequest().authenticated()
			)

			// 인증 및 인가 작업 중 발생하는 예외 처리
			.exceptionHandling(exception -> exception
				.authenticationEntryPoint(new AuthenticationFailEntryPoint())
			)

			// 필터 등록
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return security.build();

	}

	// CORS 설정
	@Bean
	protected CorsConfigurationSource configurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

	// 예외처리 설정
	class AuthenticationFailEntryPoint implements AuthenticationEntryPoint {

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
			
			authException.printStackTrace();

			// response 객체를 직접 설정
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			// 단순 문자열 응답으로 처리
			response.getWriter()
					.write(new CustomException("인증이 실패하였습니다.").getMessage());
		}
		
	}
	
}
