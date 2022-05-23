package com.sp.controller;


import java.util.Optional;

import com.sp.interceptors.AuthInterceptor;
import com.sp.model.Auth;
import com.sp.requests.LoginRequest;
import com.sp.requests.RegisterRequest;
import com.sp.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("http://front.eola.local")
public class AuthController {

	AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/auth/login")
	public Auth login(@RequestBody LoginRequest loginRequest) {
		return this.authService.login(loginRequest);
	}

	@PostMapping("/auth/register")
	public Auth register(@RequestBody RegisterRequest registerRequest){
		return this.authService.register(registerRequest);
	}

	@GetMapping("/auth/current")
	public Auth getCurrentUser(){
		Optional<Auth> user = this.authService.getUserById(AuthInterceptor.userId);
		if(user.isPresent()){
			return user.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "L'utilisateur n'est pas reconnu");
	}

	@RequestMapping(value ="/auth/healthcheck", method = RequestMethod.OPTIONS)
	public boolean healthCheckCors() {
		System.out.println("Health check");
		return true;
	}
}
