package com.sp.repository;

import com.sp.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);

    @Query("select u from User u where u.authId = ?1")
    User findByAuthId(Integer authId);
}
