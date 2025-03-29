package com.minka.optica.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class SaveUser implements Serializable {

    @Size(min = 4, max = 20, message = "Campo name: el tamaño debe estar entre 4 y 20 caracteres")
    private String name;

    @Size(min = 4, max = 80, message = "Campo username: el tamaño debe estar entre 4 y 80 caracteres")
    private String username;

    @Size(min = 8, max = 30, message = "Campo password: el tamaño debe estar entre 4 y 30 caracteres")
    private String password;

    @Size(min = 8, max = 30, message = "Campo repeatedPasswor: el tamaño debe estar entre 4 y 30 caracteres")
    private String repeatedPassword;

    // getter & setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
