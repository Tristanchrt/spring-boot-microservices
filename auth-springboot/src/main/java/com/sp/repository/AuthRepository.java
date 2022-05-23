package com.sp.repository;

import com.sp.model.Auth;

import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, Integer> {
    Auth findByEmail(String email);
}
