package com.sp.communicationlibrary.DTO.Auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RegisterDTO {
    
    @NotNull(message = "Firstname cannot be null")
    private String firstname;

    @NotNull(message = "Lastname cannot be null")
    private String lastname;

    @Email(message = "Invalid Email")
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;

    
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
