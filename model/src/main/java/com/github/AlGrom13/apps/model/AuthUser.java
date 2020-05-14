package com.github.AlGrom13.apps.model;

public class AuthUser {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private Long clientId;

    public AuthUser(Long id, String login, String password, Role role, Long clientId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Long getClientId() {
        return clientId;
    }
}
