package com.example.springsecurity.chpt5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

	@Bean
	public UserDetailsService userDetailsService(){
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("john")
				.password("12345")
				.authorities("read")
				.build();
		inMemoryUserDetailsManager.createUser(user);
		return inMemoryUserDetailsManager;
	}

	@Bean
	@SuppressWarnings("deprecation") // 학습용
	public PasswordEncoder passwordEncoder(){

		return NoOpPasswordEncoder.getInstance();
	}


}
