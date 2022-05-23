package com.sp.service;

import java.util.Optional;

import com.sp.communicationlibrary.Clients.AuthClient;
import com.sp.communicationlibrary.Clients.UserClient;
import com.sp.communicationlibrary.DTO.User.UserDTO;
import com.sp.model.Auth;
import com.sp.repository.AuthRepository;
import com.sp.requests.LoginRequest;
import com.sp.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    
    @Autowired
    JwtService jwtService;

    @Autowired
    UserClient userClient;

    // public AuthService(AuthRepository authRepository,JwtService jwtService, UserClient userClient){
    //     this.authRepository = authRepository;
    //     this.jwtService = jwtService;
    //     this.userClient = userClient;
    // }

    public Auth login(LoginRequest loginRequest) {
        Auth user = this.authRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                String token = this.jwtService.generateToken(user);
                user.setToken(token);
                return user;
            }
        }
        throw new ResponseStatusException(401, "Invalid credentials", null);
    }

    public Auth register(RegisterRequest registerRequest) {
        Auth user = new Auth(registerRequest.getEmail(), registerRequest.getPassword());
        Auth authCreated = this.authRepository.save(user);
        UserDTO new_user = new UserDTO();
        new_user.setEmail(registerRequest.getEmail());
        new_user.setFirstname(registerRequest.getFirstname());
        new_user.setLastname(registerRequest.getLastname());
        new_user.setAuthId(user.getId());
        userClient.createUser(new_user);
        String token = this.jwtService.generateToken(authCreated);
        authCreated.setToken(token);
        return authCreated;
    }

    public Optional<Auth> getUserById(Integer id) {
        Optional<Auth> user = this.authRepository.findById(id);
        return user;
    }
}
