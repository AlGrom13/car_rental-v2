package com.github.AlGrom13.apps.dao.entity;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "client_personal_data")
public class ClientPersonalDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "passport_number")
    private String passportNumber;

    @CreationTimestamp
    @Column(name = "validity_date")
    private LocalDateTime validityDate;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "client_id")
    private ClientEntity clientEntity;

    public ClientPersonalDataEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
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

    public LocalDateTime getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(LocalDateTime validityDate) {
        this.validityDate = validityDate;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }
}
