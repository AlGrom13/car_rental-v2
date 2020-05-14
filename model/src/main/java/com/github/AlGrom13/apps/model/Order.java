package com.github.AlGrom13.apps.model;

public class Order {
    private Long orderId;
    private Long carRequestId;

    public Order(Long orderId, Long carRequestId) {
        this.orderId = orderId;
        this.carRequestId = carRequestId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCarRequestId() {
        return carRequestId;
    }
}
