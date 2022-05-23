package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private String date;
    private Integer amount;
    private Integer card_id;
    private Integer user_id;

    public Transaction() {
        this.date = "";
        this.amount = 0;
        this.user_id = 0;
        this.card_id = 0;
    }

    public Transaction(String date, Integer amount, Integer card_id, Integer user_id) {
        this.date = date;
        this.amount = amount;
        this.card_id = card_id;
        this.user_id = user_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getDate() {
        return date;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

}