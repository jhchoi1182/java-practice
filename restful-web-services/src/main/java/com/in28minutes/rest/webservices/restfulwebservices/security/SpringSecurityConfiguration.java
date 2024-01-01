package com.in28minutes.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// 보안 인증을 커스텀해서 설정
@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 모든 요청에 인증 필요
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		// 팝업으로 뜨도록 설정
		http.httpBasic(withDefaults());
		
		// CSRF를 해제해서 POST 요청을 보낼 수 있게 설정
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
