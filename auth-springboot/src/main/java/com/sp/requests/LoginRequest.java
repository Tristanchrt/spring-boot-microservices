package com.sp.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LoginRequest {
    @Email(message = "Invalid Email")
    @NotNull(message = "Email cannot be null")
    String email;


    @NotNull(message = "Password cannot be null")
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
}
