package com.sp.controller;


import com.sp.communicationlibrary.DTO.Game.GameDTO;
import com.sp.model.Game;
import com.sp.service.GameService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://front.eola.local")
public class GameController {

	GameService gameSerice;

	public GameController(GameService gameSerice) {
		this.gameSerice = gameSerice;
	}

	@GetMapping("/games/{id}")
	public Game get(@PathVariable("id") int id) {
		return this.gameSerice.getGame(id);
	}
	
	@GetMapping("/games")
	public List<Game> getGames() {
		return new ArrayList<Game>(this.gameSerice.getGames().values());
	}
 
	@PostMapping("/games")
	public Game createGame(@RequestBody GameDTO game) {
		return this.gameSerice.createGame(game);
	}

	@PostMapping("/gamesUpdate/{id}")
	public Game updateGame(@PathVariable("id") int id, @RequestBody GameDTO game) {
		return this.gameSerice.addCardUserGame(id, game);
	}

	@PostMapping("/games/startBattle")
	public Game startBattle(@RequestBody GameDTO gameToStart) {
		return this.gameSerice.battle(gameToStart);
	}

}
