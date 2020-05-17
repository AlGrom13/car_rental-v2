package com.github.AlGrom13.apps.model;

import java.util.Date;

public class CarOrderInfo {
    private CarOrder carOrder;
    private Date beginDate;
    private Date endDate;
    private int totalPrice;

    public CarOrderInfo(CarOrder carOrder) {
        this.carOrder = carOrder;
    }

    public CarOrder getCarOrder() {
        return carOrder;
    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
