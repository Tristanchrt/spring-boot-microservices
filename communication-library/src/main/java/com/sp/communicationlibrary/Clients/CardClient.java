package com.sp.communicationlibrary.Clients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.sp.communicationlibrary.DTO.Card.CardDTO;

@FeignClient(name = "microservice-cards", url = "internal.eola.local")
public interface CardClient {
    @GetMapping(value = "/cards")
    Iterable<CardDTO> getCards();


    @GetMapping(value = "/card/{id}")
    CardDTO getCard(@PathVariable("id") Integer id);

    @GetMapping(value = "/cards/my")
    Iterable<CardDTO> getMyCards();


    @PostMapping(value= "/card")
	CardDTO createCard(@RequestBody CardDTO card);

    @PutMapping(value = "/card/{id}")
	public CardDTO updateCard(@PathVariable("id") Integer id, @RequestBody CardDTO card);

    @DeleteMapping(value = "/card/{id}")
	public boolean delete(@PathVariable("id") Integer id);


    @GetMapping(value = "/cards/buyable")
	public Iterable<CardDTO> listBuyable();
}
