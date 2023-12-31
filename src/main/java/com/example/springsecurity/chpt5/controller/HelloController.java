package com.example.springsecurity.chpt5.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

	@GetMapping("/hello")
	public String hello(Authentication authentication){
		log.info("HelloController.hello");
		return "Hello, " + authentication.getName();
	}

	@GetMapping("/hello2")
	public String hello2(){
		log.info("HelloController.hello2");
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();

		return "Hello, " + authentication.getName();
	}

}
