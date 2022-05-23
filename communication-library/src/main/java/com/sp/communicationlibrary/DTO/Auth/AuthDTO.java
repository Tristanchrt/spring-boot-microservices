package com.sp.communicationlibrary.DTO.Auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AuthDTO {
    private Integer id;

    @Email(message = "Invalid Email")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Firstname cannot be null")
    private String password;

    private String token;
   
    public AuthDTO(){}
    public AuthDTO(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
    public Integer getId() {
        return id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
