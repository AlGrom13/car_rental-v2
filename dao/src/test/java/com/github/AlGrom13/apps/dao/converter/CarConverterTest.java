package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.CarEntity;
import com.github.AlGrom13.apps.model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarConverterTest {

    @Test
    void fromEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(1l);
        carEntity.setBrand("brand");
        carEntity.setModel("model");
        carEntity.setReleaseDate("date");
        carEntity.setPricePerDay(100);
        carEntity.setRegisterNumber("reg_number");

        Car car = CarConverter.fromEntity(carEntity);

        assertNotNull(car);
        assertEquals(carEntity.getCarId(), car.getCarId());
        assertEquals(carEntity.getBrand(), car.getBrand());
        assertEquals(carEntity.getModel(), car.getModel());
        assertEquals(carEntity.getReleaseDate(), car.getReleaseDate());
        assertEquals(carEntity.getRegisterNumber(), car.getRegisterNumber());
        assertEquals(carEntity.getPricePerDay(), car.getPricePerDay());
    }

    @Test
    void toEntity() {
        Car car = new Car(
                1l,
                "brand",
                "model",
                "date",
                100
        );
        car.setRegisterNumber("reg_num");

        CarEntity carEntity = CarConverter.toEntity(car);

        assertNotNull(carEntity);
        assertEquals(car.getCarId(), carEntity.getCarId());
        assertEquals(car.getBrand(), carEntity.getBrand());
        assertEquals(car.getModel(), carEntity.getModel());
        assertEquals(car.getReleaseDate(), carEntity.getReleaseDate());
        assertEquals(car.getRegisterNumber(), carEntity.getRegisterNumber());
        assertEquals(car.getPricePerDay(), carEntity.getPricePerDay());
    }
}