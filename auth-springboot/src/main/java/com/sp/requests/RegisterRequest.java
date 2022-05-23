package com.sp.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RegisterRequest {
    @NotNull(message = "Firstname cannot be null")
    String firstname;

    @NotNull(message = "Firstname cannot be null")
    String lastname;

    @Email(message = "Invalid email")
    String email;

    @NotNull(message = "Firstname cannot be null")
    String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
