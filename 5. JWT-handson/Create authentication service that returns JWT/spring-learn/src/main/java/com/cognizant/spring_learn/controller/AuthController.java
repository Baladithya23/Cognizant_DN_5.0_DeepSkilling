package com.cognizant.spring_learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.util.JwtUtil;

@RestController
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(Authentication authentication) {
		logger.info("Start - authenticate() method");

		// Spring Security has ALREADY validated the Basic Auth credentials
		// by the time this method runs. If invalid, it never even reaches here.
		String username = authentication.getName();
		logger.info("Authenticated user: {}", username);

		String token = jwtUtil.generateToken(username);

		Map<String, String> response = new HashMap<>();
		response.put("token", token);

		logger.info("End - authenticate() method");
		return response;
	}

}