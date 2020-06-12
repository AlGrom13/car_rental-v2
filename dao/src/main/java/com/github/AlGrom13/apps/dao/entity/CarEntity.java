package com.github.AlGrom13.apps.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "register_number")
    private String registerNumber;

    @Column(name = "price_per_day")
    private int pricePerDay;

    @OneToMany(mappedBy = "carEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CarOrderEntity> orders;

    @ManyToMany(
            mappedBy = "rentedCars",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private List<ClientEntity> clients;

    public CarEntity() {

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public List<CarOrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<CarOrderEntity> orders) {
        this.orders = orders;
    }

    public List<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(List<ClientEntity> clients) {
        this.clients = clients;
    }
}
