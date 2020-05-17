package com.github.AlGrom13.apps.model;

import java.util.List;

public class ClientHistory {
    private Client client;
    private List<Car> rentedCars;
    private List<CarOrder> carOrders;

    public ClientHistory(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(List<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public List<CarOrder> getCarOrders() {
        return carOrders;
    }

    public void setCarOrders(List<CarOrder> carOrders) {
        this.carOrders = carOrders;
    }
}
