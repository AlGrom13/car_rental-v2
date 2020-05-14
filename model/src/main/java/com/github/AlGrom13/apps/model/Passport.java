package com.github.AlGrom13.apps.model;

import java.util.Date;

public class Passport {
    private long id;
    private String nationality;
    private String passportNumber;
    private Date validityDate;

    public Passport(String nationality, String passportNumber, Date validityDate) {
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.validityDate = validityDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Date getValidityDate() {
        return validityDate;
    }
}
