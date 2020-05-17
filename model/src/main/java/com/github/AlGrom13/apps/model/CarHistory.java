package com.github.AlGrom13.apps.model;

import java.util.List;

public class CarHistory {
    private Car car;
    private List<Client> clients;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
