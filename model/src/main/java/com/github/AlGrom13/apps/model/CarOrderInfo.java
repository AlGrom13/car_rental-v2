package com.github.AlGrom13.apps.model;

import java.time.LocalDateTime;

public class CarOrderInfo {
    private CarOrder carOrder;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private int totalPrice;

    public CarOrderInfo() {

    }

    public CarOrderInfo(CarOrder carOrder) {
        this.carOrder = carOrder;
    }

    public CarOrder getCarOrder() {
        return carOrder;
    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
