package com.github.AlGrom13.apps.model;

public class CarOrder {
    private Long carOrderId;
    private Client client;
    private Car car;
    private CarOrderInfo carOrderInfo;
    private CarOrderStatus carOrderStatus;

    public CarOrder(Long carOrderId, Client client, Car car, CarOrderInfo carOrderInfo, CarOrderStatus carOrderStatus) {
        this.carOrderId = carOrderId;
        this.client = client;
        this.car = car;
        this.carOrderInfo = carOrderInfo;
        this.carOrderStatus = carOrderStatus;
    }

    public Long getCarOrderId() {
        return carOrderId;
    }

    public void setCarOrderId(Long carOrderId) {
        this.carOrderId = carOrderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarOrderInfo getCarOrderInfo() {
        return carOrderInfo;
    }

    public void setCarOrderInfo(CarOrderInfo carOrderInfo) {
        this.carOrderInfo = carOrderInfo;
    }

    public CarOrderStatus getCarOrderStatus() {
        return carOrderStatus;
    }

    public void setCarOrderStatus(CarOrderStatus carOrderStatus) {
        this.carOrderStatus = carOrderStatus;
    }
}
