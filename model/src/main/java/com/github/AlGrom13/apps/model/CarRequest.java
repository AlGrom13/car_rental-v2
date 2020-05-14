package com.github.AlGrom13.apps.model;

import java.util.Date;

public class CarRequest {
    private Long carRequestId;
    private Long carId;
    private Long clientId;
    private Date beginDate;
    private Date endDate;
    private CarRequestStatus carRequestStatus;

    public CarRequest(Long carRequestId, Long carId, Long clientId, Date beginDate, Date endDate) {
        this.carRequestId = carRequestId;
        this.carId = carId;
        this.clientId = clientId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.carRequestStatus = CarRequestStatus.PROCESSING;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CarRequestStatus getCarRequestStatus() {
        return carRequestStatus;
    }

    public void setCarRequestStatus(CarRequestStatus carRequestStatus) {
        this.carRequestStatus = carRequestStatus;
    }
}
