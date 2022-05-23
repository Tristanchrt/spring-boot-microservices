package com.sp.model;


public class Game {
    private Integer id;
    private String name;
    private Integer bet;
    private Integer player1;
    private Integer player2;
    private Integer cardPlayer1;
    private Integer cardPlayer2;
    private Integer status;

    // GETTER AND SETTER

    public Game(Integer id, String name, Integer bet, Integer player1) {
        this.id = id;
        this.name = name;
        this.bet = bet;
        this.player1 = player1;
        this.player2 = 0;
        this.cardPlayer1 = 0;
        this.cardPlayer2 = 0;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
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