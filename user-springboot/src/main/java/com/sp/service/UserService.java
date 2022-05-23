package com.sp.service;

import java.util.Optional;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    public User getUserByAuthId(Integer authId){
        User user = this.userRepository.findByAuthId(authId);
        return user;
    }


    public Iterable<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> userOptional = this.userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            User userUpdated = this.userRepository.save(userOptional.get());
            return userUpdated;
        }
        return null;
    }
}