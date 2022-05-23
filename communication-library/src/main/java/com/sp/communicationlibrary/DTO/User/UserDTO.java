package com.sp.communicationlibrary.DTO.User;

public class UserDTO {
    private Integer id;

    private String email;

    private String firstname;

    private String lastname;

    private Integer sold = 0;

    private Integer authId;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getSold() {
        return sold;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
}

