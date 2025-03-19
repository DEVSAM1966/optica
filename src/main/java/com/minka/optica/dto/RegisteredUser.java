package com.minka.optica.dto;

import java.io.Serializable;

public class RegisteredUser implements Serializable {

    private Long id;

    private String username;

    private String name;

    // Nos vendrá los roles como un String desde el cliente
    private String role;

    // Nuestro caso contempla que cuando nos registremos genere un token.
    // Lo habitual es registrarse y luego proceder hacer un login que genera el token.
    private String jwt;

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
