package com.github.AlGrom13.apps.dao.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

public class CarOrderInfoEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private CarOrderEntity carOrderEntity;

    @CreationTimestamp
    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    @CreationTimestamp
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "total_price")
    private int totalPrice;

    public CarOrderInfoEntity() {}

    public CarOrderEntity getCarOrderEntity() {
        return carOrderEntity;
    }

    public void setCarOrderEntity(CarOrderEntity carOrderEntity) {
        this.carOrderEntity = carOrderEntity;
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
