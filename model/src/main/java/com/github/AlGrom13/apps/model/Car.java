package com.github.AlGrom13.apps.model;

import java.util.List;

public class Car {
    private Long carId;
    private String brand;
    private String model;
    private String releaseDate;
    private String registerNumber;
    private int pricePerDay;
    private List<CarOrder> orders;
    private List<Client> clients;

    public Car(Long carId, String brand, String model, String releaseDate, int pricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.releaseDate = releaseDate;
        this.pricePerDay = pricePerDay;
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

    public String getModel() {
        return model;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public List<CarOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CarOrder> orders) {
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
