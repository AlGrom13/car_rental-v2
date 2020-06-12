package com.github.AlGrom13.apps.dao;

import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.CarOrderStatus;

import java.util.List;

public interface CarOrderDao {

    CarOrder getCarOrderById(Long carOrderId);

    List<CarOrder> getAllCarOrders();

    void saveCarOrder(CarOrder carOrder);

    void updateCarOrder(CarOrder carOrder);

    void updateCarOrderStatus(Long carOrderId, CarOrderStatus carOrderStatus);

    void deleteCarOrderById(Long carOrderId);
}
