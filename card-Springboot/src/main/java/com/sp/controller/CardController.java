package com.sp.controller;

import java.util.Optional;

import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.model.Card;
import com.sp.service.CardService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://front.eola.local")
public class CardController {

	CardService cardService;

	public CardController(CardService cardService) {	
		this.cardService = cardService;
	}

	@GetMapping("/card/{id}")	
	public Optional<Card> show(@PathVariable("id") int id) {
		return this.cardService.show((Integer) id);
	}

	@GetMapping("/cards/my")
	public Iterable<Card> getMyCards(){
		return this.cardService.getMyCards();
	}

	@PostMapping("/card")
	public Card create(@RequestBody Card card) {
		return this.cardService.create(card);
	}

	@PutMapping("/card/{id}")
	public Card updateCard(@PathVariable("id") Integer id, @RequestBody Card card) {
		return this.cardService.updateCard(card);
	}

	@DeleteMapping("/card/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		return this.cardService.delete(id);
	}

	@GetMapping("/cards")
	public Iterable<Card> list() {
		return this.cardService.getCards();
	}

	@GetMapping("/cards/buyable")
	public Iterable<Card> listBuyable() {
		return this.cardService.listBuyable();
	}

}
