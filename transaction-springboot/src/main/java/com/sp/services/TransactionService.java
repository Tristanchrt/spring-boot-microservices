package com.sp.services;

import java.util.Optional;

import com.sp.communicationlibrary.Clients.CardClient;
import com.sp.communicationlibrary.Clients.UserClient;
import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.communicationlibrary.DTO.User.UserDTO;
import com.sp.interceptors.AuthInterceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class TransactionService {


    private CardClient cardClient; 
    private UserClient userClient;
    public TransactionService(CardClient cardClient, UserClient userClient) {
        this.cardClient = cardClient;
        this.userClient = userClient;
    }

    public CardDTO buy(Integer cardId) {
        CardDTO card = this.cardClient.getCard(cardId);
        if (card != null) {
            if (!card.getIs_to_sell()) {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card is not in store");
            }
            final UserDTO buyer = this.userClient.getUser(AuthInterceptor.userId);
            final UserDTO seller = this.userClient.getUser(card.getOwner());
            if (buyer.getSold() >= card.getPrice()) {
                buyer.setSold(buyer.getSold() - card.getPrice());
                seller.setSold(seller.getSold() + card.getPrice());
                userClient.updateUser(buyer.getId(), buyer);
                userClient.updateUser(seller.getId(), seller);

                card.setOwner(buyer.getId());
                card.setIs_to_sell(false);
                this.cardClient.updateCard(card.getId(), card);
                return card;
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Insufficient balance");
            }
        }
        throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card not found");
    }

    public CardDTO sell(Integer cardId, Integer price) {
        CardDTO card = this.cardClient.getCard(cardId);
        if (card != null) {
            if (card.getOwner().equals(AuthInterceptor.userId)) {
                card.setIs_to_sell(true);
                card.setPrice(price);
                cardClient.updateCard(card.getId(), card);
                return card;
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "You are not the owner of this card");
            }
        }
        throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card not found");
    }

    public CardDTO cancelSell(Integer cardId) {
        CardDTO card = this.cardClient.getCard(cardId);
        if (card != null) {
            if (card.getOwner().equals(AuthInterceptor.userId)) {
                card.setIs_to_sell(false);
                this.cardClient.updateCard(cardId, card);
                return card;
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "You are not the owner of this card");
            }
        }
        throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Card not found");
    }
}
