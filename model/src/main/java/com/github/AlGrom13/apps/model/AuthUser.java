package com.github.AlGrom13.apps.model;

public class AuthUser {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private Client client;


    public AuthUser(Long id, String login, String password, Role role, Client client) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
