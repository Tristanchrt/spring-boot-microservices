package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sold")
    private Integer sold = 1000;

    @Column(name = "auth_id")
    private Integer authId;

    public User(){}
    public User(String email, String lastname, String firstname, Integer sold, Integer authId){
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.authId = authId;
        this.sold = sold;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public Integer getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getSold() {
        return sold;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getAuthId() {
        return authId;
    }
}
