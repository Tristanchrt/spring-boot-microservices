package com.sp.communicationlibrary.Clients;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.communicationlibrary.DTO.Transaction.SellDTO;

@FeignClient(name = "microservice-transactions", url = "internal.eola.local")
public interface TransactionClient {
    @PostMapping("/transaction/buy/{id}")
    public CardDTO buy(@PathVariable("id") Integer cardId);

    @PostMapping("/transaction/sell/{id}")
    public CardDTO sell(@PathVariable("id") Integer cardId, @RequestBody SellDTO sellRequest);
    
    @PutMapping("/transaction/sell/{id}")
    public CardDTO cancelSell(@PathVariable("id") Integer cardId);
}
