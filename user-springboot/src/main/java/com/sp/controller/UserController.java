package com.sp.controller;


import java.util.Optional;

import com.sp.communicationlibrary.DTO.User.UserDTO;
import com.sp.communicationlibrary.DTOMapper.DTOModelMapper;
import com.sp.interceptors.AuthInterceptor;
import com.sp.model.User;
import com.sp.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("http://front.eola.local")
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id){
		Optional<User> user = this.userService.getUserById(id);
		if(user.isPresent()){
			return user.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "L'utilisateur n'est pas reconnu");
	}

	@GetMapping("/user/auth/{id}")
	public User getUserByAuthId(@PathVariable("id") Integer authId){
		return this.userService.getUserByAuthId(authId);
	}


	@GetMapping("/users")
	public Iterable<User> users(){
		Iterable<User> users = this.userService.getUsers();
		return users;
	}


	@PostMapping("/user")
	public UserDTO createUser(@RequestBody UserDTO userDto){
		User newUser =  this.userService.createUser(DTOModelMapper.map(userDto, User.class));
		return DTOModelMapper.map(newUser, UserDTO.class);
	}


	@PutMapping("/user/{id}")
    public UserDTO updateUser(@PathVariable("id") Integer userId, @RequestBody UserDTO user) {
		User updatedUser = this.userService.updateUser(DTOModelMapper.map(user, User.class));
		if (updatedUser != null){
			return DTOModelMapper.map(updatedUser, UserDTO.class);
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "L'utilisateur n'est pas reconnu");
	}
}
