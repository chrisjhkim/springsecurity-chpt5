package com.example.springsecurity.chpt5.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation") // 학슴 용
@Component
@RequiredArgsConstructor
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
	private final AuthenticationProvider authenticationProvider;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests()
				.anyRequest().authenticated();

	}

	// 사실 여기서 override 통해서 설정을 안해도 적용이 된다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider( authenticationProvider );
	}
}
