package com.github.AlGrom13.apps.dao;

import com.github.AlGrom13.apps.model.Car;
import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.Client;

import java.util.List;

public interface CarDao {

    Car getById(Long carId);

    List<Car> getAllCars();

    List<CarOrder> getOrders(Long carId);

    List<Client> getClients(Long carId);

    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long carId);
}
