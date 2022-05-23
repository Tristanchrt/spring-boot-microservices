package com.sp.communicationlibrary.DTO.Game;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class GameDTO {

    private Integer id;

    private String name;

    @Digits(integer =  999999, fraction = 0)
    private Integer bet;
    
    private Integer player1;
    
    private Integer player2;
    
    private Integer cardPlayer1;
    
    private Integer cardPlayer2;
    
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public Integer getPlayer1() {
        return player1;
    }

    public void setPlayer1(Integer player1) {
        this.player1 = player1;
    }

    public Integer getPlayer2() {
        return player2;
    }

    public void setPlayer2(Integer player2) {
        this.player2 = player2;
    }

    public Integer getCardPlayer1() {
        return cardPlayer1;
    }

    public void setCardPlayer1(Integer cardPlayer1) {
        this.cardPlayer1 = cardPlayer1;
    }

    public Integer getCardPlayer2() {
        return cardPlayer2;
    }

    public void setCardPlayer2(Integer cardPlayer2) {
        this.cardPlayer2 = cardPlayer2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
