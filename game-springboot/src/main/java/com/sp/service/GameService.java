package com.sp.service;

import java.util.HashMap;

import com.sp.communicationlibrary.Clients.CardClient;
import com.sp.communicationlibrary.Clients.UserClient;
import com.sp.communicationlibrary.DTO.Card.CardDTO;
import com.sp.communicationlibrary.DTO.Game.GameDTO;
import com.sp.communicationlibrary.DTO.User.UserDTO;
import com.sp.model.Game;

import org.springframework.stereotype.Service;


@Service
public class GameService {

    CardClient cardClient;
    UserClient userClient;

	public GameService(UserClient userClient, CardClient cardClient) {
		this.cardClient = cardClient;
        this.userClient = userClient;
	}

    public HashMap<Integer, Game> games = new HashMap<>(); 

    public Integer lastGameId = 1;

    public Game createGame(GameDTO new_game) {
        Game game = new Game(this.lastGameId, new_game.getName(), new_game.getBet(), new_game.getPlayer1());
        game.setStatus(1);
        this.lastGameId += 1;
        this.games.put(game.getId(), game);
        return game;
    }

    public Game getGame(Integer id){
        return this.games.get(id);
    }

    public HashMap<Integer, Game> getGames() {
        HashMap<Integer, Game> new_games = new HashMap<>(); 
        this.games.forEach((k, v) -> {
            if(v.getStatus() != 3)
                new_games.put(v.getId(), v);
        });
        return new_games;
    }

    public Game addCardUserGame(Integer id, GameDTO gameToUpdate) {
        Game game = this.getGame(id);
		System.out.print(game);
        if (game.getCardPlayer1() == 0 && game.getCardPlayer2() == 0) {
            game.setCardPlayer1(gameToUpdate.getCardPlayer1());
        }else if (game.getCardPlayer1() != 0 && game.getCardPlayer2() == 0){
            game.setPlayer2(gameToUpdate.getPlayer2());
            game.setCardPlayer2(gameToUpdate.getCardPlayer2());
        }
        if(game.getCardPlayer1() != 0 && game.getCardPlayer2() != 0){
            game.setStatus(2);
        }
        return game;
    }

    public Game battle(GameDTO gameToStart) {
        Game game = this.getGame(gameToStart.getId());
        game.setStatus(3);

        CardDTO cardPlayer1 = this.cardClient.getCard(game.getCardPlayer1());
        CardDTO cardPlayer2 = this.cardClient.getCard(game.getCardPlayer2());

        Integer card1Stat = Math.abs(cardPlayer1.getAttack() - cardPlayer1.getDefense());
        Integer card2Stat = Math.abs(cardPlayer2.getAttack() - cardPlayer2.getDefense());

        UserDTO user1 = this.userClient.getUser(game.getPlayer1());
        UserDTO user2 = this.userClient.getUser(game.getPlayer1());
        
        if(card1Stat > card2Stat){
            game.setCardPlayer2(null);
            user1.setSold(user1.getSold()+game.getBet());
            user1.setSold(user2.getSold()-game.getBet());
        }else{
            game.setCardPlayer1(null);
            user1.setSold(user2.getSold()+game.getBet());
            user1.setSold(user1.getSold()-game.getBet());
        }
        return game;
    }
}
