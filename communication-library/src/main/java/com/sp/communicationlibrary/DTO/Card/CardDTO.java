package com.sp.communicationlibrary.DTO.Card;
import javax.validation.constraints.NotNull;

public class CardDTO {

    private Integer id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Family cannot be null")
    private String family;

    @NotNull(message = "Image URL cannot be null")
    private String image_url;

    @NotNull(message = "Affinity cannot be null")
    private String affinity;

    @NotNull(message = "HP cannot be null")
    private Integer hp;

    @NotNull(message = "Energy cannot be null")
    private Integer energy;

    @NotNull(message = "Attack cannot be null")
    private Integer attack;

    @NotNull(message = "Defense cannot be null")
    private Integer defense;

    @NotNull(message = "Owner cannot be null")
    private Integer owner;

    @NotNull(message = "Price cannot be null")
    private Integer price;

    @NotNull(message = "Is to sell cannot be null")
    public Boolean is_to_sell;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFamily() {
        return family;
    }

    public String getAffinity() {
        return affinity;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getHp() {
        return hp;
    }

    public String getImage_url() {
        return image_url;
    }

    public Boolean getIs_to_sell() {
        return is_to_sell;
    }

    public Integer getOwner() {
        return owner;
    }

    public Integer getPrice() {
        return price;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setIs_to_sell(Boolean is_to_sell) {
        this.is_to_sell = is_to_sell;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
