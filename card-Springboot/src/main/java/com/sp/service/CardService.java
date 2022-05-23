package com.sp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.interceptors.AuthInterceptor;
import com.sp.model.Card;
import com.sp.repository.CardRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public Optional<Card> show(Integer id) {
        return this.cardRepository.findById(id);
    }

    public List<Card> getMyCards(){
        return this.cardRepository.findByOwnerId(AuthInterceptor.userId);
    }

    public Iterable<Card> getCards() {
        return this.cardRepository.findAll();
    }

    public Iterable<Card> listBuyable(){
        return this.cardRepository.findByIsToSell(true);
    }

    public Card create(Card card) {
        this.cardRepository.save(card);
        return card;
    }

    public Card updateCard(Card cardDto) {
        Optional<Card> card = this.cardRepository.findById(cardDto.getId());
        if(card.isPresent()){
            Card cardUpdated = this.cardRepository.save(cardDto);
            // ModelMapper modelMapper = new ModelMapper();
            // CardDTO newCardDto = modelMapper.map(cardUpdated, CardDTO.class);
            return cardUpdated;
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "La carte n'a pas été trouver");
    }

    public boolean delete(Integer id) {
        Card card = this.show(id).get();
        this.cardRepository.delete(card);
        return true;
    }

    public Card update(Card card) {
        this.cardRepository.save(card);
        return card;
    }

}
