package com.github.AlGrom13.apps.model;

import java.util.Date;

public class ClientPersonalData {
    private Long id;
    private Date dateOfBirth;
    private String nationality;
    private String passportNumber;
    private Date validityDate;
    private Client client;

    public ClientPersonalData(Client client) {
        this.client = client;
    }

    public ClientPersonalData(Long id, Date dateOfBirth, String nationality,
                              String passportNumber, Date validityDate, Client client) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.validityDate = validityDate;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
