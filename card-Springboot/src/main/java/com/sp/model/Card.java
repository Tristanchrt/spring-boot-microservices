package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "family")
    private String family;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "affinity")
    private String affinity;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "energy")
    private Integer energy;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;    

    @Column(name = "owner")
    private Integer owner;

    @Column(name = "price")
    private Integer price;

    @Column(name = "is_to_sell")
    public Boolean is_to_sell;


    public Card() {
        this.family = "";
        this.description = "";
        this.name = "";
        this.image_url = "";
        this.affinity = "";
        this.hp = 0;
        this.energy = 0;
        this.attack = 0;
        this.defense = 0;
        this.price = 0;
        this.is_to_sell = false;
        this.owner = null;
    }

    public Card(String name, String description, String family, String image_url, String affinity, Integer hp,
            Integer energy, Integer attack, Integer defense, Integer owner, Integer price, Boolean sellStatus) {
        this.description = description;
        this.family = family;
        this.affinity = affinity;
        this.name = name;
        this.image_url = image_url;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
        this.price = price;
        this.owner = owner;
        this.is_to_sell = false;
    }

    // GETTER AND SETTER

    public Integer getId() {
        return id;
    }

    public Integer getOwner() {
        return owner;
    }
    public String getImage_url() {
        return image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setIs_to_sell(boolean sellStatus) {
        this.is_to_sell = sellStatus;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFamily() {
        return family;
    }

    public String getAffinity() {
        return affinity;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getEnergy() {
        return energy;
    }


    public Integer getPrice() {
        return price;
    }

    public boolean getIs_to_sell() {
        return is_to_sell;
    }
}