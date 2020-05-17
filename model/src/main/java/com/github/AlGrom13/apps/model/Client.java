package com.github.AlGrom13.apps.model;

public class Client {
    private Long id;
    private String lastName;
    private String firstName;
    private Sex sex;
    private AuthUser authUser;
    private ClientPersonalData clientPersonalData;
    private ClientHistory clientHistory;

    public Client(Long id, String lastName, String firstName, Sex sex, ClientPersonalData clientPersonalData) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sex = sex;
        this.clientPersonalData = clientPersonalData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    public ClientPersonalData getClientPersonalData() {
        return clientPersonalData;
    }

    public void setClientPersonalData(ClientPersonalData clientPersonalData) {
        this.clientPersonalData = clientPersonalData;
    }

    public ClientHistory getClientHistory() {
        return clientHistory;
    }

    public void setClientHistory(ClientHistory clientHistory) {
        this.clientHistory = clientHistory;
    }
}
