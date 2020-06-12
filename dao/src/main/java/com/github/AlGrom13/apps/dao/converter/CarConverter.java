package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.CarEntity;
import com.github.AlGrom13.apps.model.Car;

public class CarConverter {

    public static Car fromEntity(CarEntity carEntity) {
        if (carEntity == null) {
            return null;
        } else {
            Car car = new Car(
                    carEntity.getCarId(),
                    carEntity.getBrand(),
                    carEntity.getModel(),
                    carEntity.getReleaseDate(),
                    carEntity.getPricePerDay()
            );
            car.setRegisterNumber(carEntity.getRegisterNumber());
            return car;
        }
    }

    public static CarEntity toEntity(Car car) {
        if (car == null) {
            return null;
        } else {
            CarEntity carEntity = new CarEntity();
            carEntity.setCarId(car.getCarId());
            carEntity.setBrand(car.getBrand());
            carEntity.setModel(car.getModel());
            carEntity.setReleaseDate(car.getReleaseDate());
            carEntity.setPricePerDay(car.getPricePerDay());
            carEntity.setRegisterNumber(car.getRegisterNumber());
            return carEntity;
        }
    }
}
