package com.github.AlGrom13.apps.dao.entity;

import com.github.AlGrom13.apps.model.Role;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class AdminEntity {
    private Long id;
    private String login;
    private String password;
    private Role role;

    public AdminEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
