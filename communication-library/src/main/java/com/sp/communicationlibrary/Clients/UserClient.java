package com.sp.communicationlibrary.Clients;

import com.sp.communicationlibrary.DTO.User.UserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-users", url = "internal.eola.local")
public interface UserClient {
    
	@GetMapping("/user/{id}")
	public UserDTO getUser(@PathVariable("id") Integer id);

	@GetMapping("/users")
	public Iterable<UserDTO> users();

	@PostMapping("/user")
	public UserDTO createUser(@RequestBody UserDTO userDto);

    @PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable("id") Integer userId, @RequestBody UserDTO user);
}
