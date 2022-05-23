package com.sp.repository;

import com.sp.model.Transaction;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}