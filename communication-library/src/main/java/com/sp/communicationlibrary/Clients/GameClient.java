package com.sp.communicationlibrary.Clients;

import java.util.Map;

import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.communicationlibrary.DTO.Game.GameDTO;
import com.sp.communicationlibrary.DTO.User.UserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-games", url = "internal.eola.local")
public interface GameClient {
    
    @GetMapping(value = "/games/{id}")
	GameDTO getGame(@PathVariable("id") int id);
    
    @GetMapping(value = "/games")
	Map<Integer, GameDTO> getGames();

    @PostMapping(value= "/games")
	GameDTO createGame(@RequestBody GameDTO game);

	@PostMapping("/gamesUpdate/{id}")
	GameDTO updateGame(@PathVariable("id") int id, @RequestBody GameDTO game);

	
}