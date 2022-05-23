package com.sp.repository;

import java.util.List;
import java.util.Optional;

import com.sp.communicationlibrary.DTO.User.UserDTO;
import com.sp.model.Card;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends CrudRepository<Card, Integer> {

    @Query("select c from Card c where c.owner = ?1")
    List<Card> findByOwnerId(Integer ownerId);

    @Query("select c from Card c where c.is_to_sell = ?1")
    Iterable<Card> findByIsToSell(boolean value);


    // UserDTO find();
}
