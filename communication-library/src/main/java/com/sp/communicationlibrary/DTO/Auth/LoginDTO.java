package com.sp.communicationlibrary.DTO.Auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginDTO {
    @Email(message = "Invalid Email")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Firstname cannot be null")
    private String password;


    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
