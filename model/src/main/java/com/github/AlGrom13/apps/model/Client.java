package com.github.AlGrom13.apps.model;

import java.util.Date;

public class Client {
    private Long id;
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private Passport passport;

    public Client(Long id, String lastName, String firstName, Date dateOfBirth, Passport passport) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.passport = passport;
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

    public String getFirstName() {
        return firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Passport getPassport() {
        return passport;
    }
}
