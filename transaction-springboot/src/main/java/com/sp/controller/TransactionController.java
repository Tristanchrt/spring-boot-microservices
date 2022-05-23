package com.sp.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.communicationlibrary.DTO.Transaction.SellDTO;
import com.sp.services.TransactionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://front.eola.local")
public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction/buy/{id}")
    public CardDTO buy(@PathVariable("id") Integer cardId) {
        return this.transactionService.buy(cardId);
    }

    @PostMapping("/transaction/sell/{id}")
    public CardDTO sell(@PathVariable("id") Integer cardId, @RequestBody SellDTO sellRequest) {
        return this.transactionService.sell(cardId, sellRequest.getPrice());
    }

    @PutMapping("/transaction/sell/{id}")
    public CardDTO cancelSell(@PathVariable("id") Integer cardId) {
        return this.transactionService.cancelSell(cardId);
    }


}
