package com.sp.communicationlibrary.Clients;

import com.sp.communicationlibrary.DTO.Auth.AuthDTO;
import com.sp.communicationlibrary.DTO.Auth.LoginDTO;
import com.sp.communicationlibrary.DTO.Auth.RegisterDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-auth", url = "internal.eola.local")
public interface AuthClient {
    
	@PostMapping("/auth/login")
	public AuthDTO login(@RequestBody LoginDTO loginRequest);

	@PostMapping("/auth/register")
	public AuthDTO register(@RequestBody RegisterDTO registerRequest);

	@GetMapping("/auth/current")
	public AuthDTO getCurrentUser();
}
