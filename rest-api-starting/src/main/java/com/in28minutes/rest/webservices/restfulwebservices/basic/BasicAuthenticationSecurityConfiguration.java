package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // OPTIONS 요청을 제외(인증API에 필요)한 모든 요청에 인증 필요
        http.authorizeHttpRequests(
                auth -> auth.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
        );

        // 팝업으로 뜨도록 설정
        http.httpBasic(withDefaults());

        // CSRF를 해제해서 POST 요청을 보낼 수 있게 설정
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}