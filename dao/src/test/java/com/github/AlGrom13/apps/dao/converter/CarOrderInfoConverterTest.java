package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.CarOrderInfoEntity;
import com.github.AlGrom13.apps.model.CarOrderInfo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CarOrderInfoConverterTest {

    @Test
    void fromEntity() {
        CarOrderInfoEntity carOrderInfoEntity = new CarOrderInfoEntity();
        carOrderInfoEntity.setTotalPrice(100);
        carOrderInfoEntity.setEndDate(LocalDateTime.now());
        carOrderInfoEntity.setBeginDate(LocalDateTime.now());

        CarOrderInfo carOrderInfo = CarOrderInfoConverter.fromEntity(carOrderInfoEntity);

        assertNotNull(carOrderInfo);
        assertEquals(carOrderInfoEntity.getBeginDate(), carOrderInfo.getBeginDate());
        assertEquals(carOrderInfoEntity.getEndDate(), carOrderInfo.getEndDate());
        assertEquals(carOrderInfoEntity.getTotalPrice(), carOrderInfo.getTotalPrice());
    }

    @Test
    void toEntity() {
        CarOrderInfo carOrderInfo = new CarOrderInfo();
        carOrderInfo.setBeginDate(LocalDateTime.now());
        carOrderInfo.setEndDate(LocalDateTime.now());
        carOrderInfo.setTotalPrice(100);

        CarOrderInfoEntity carOrderInfoEntity = CarOrderInfoConverter.toEntity(carOrderInfo);

        assertNotNull(carOrderInfoEntity);
        assertEquals(carOrderInfo.getBeginDate(), carOrderInfoEntity.getBeginDate());
        assertEquals(carOrderInfo.getEndDate(), carOrderInfoEntity.getEndDate());
        assertEquals(carOrderInfo.getTotalPrice(), carOrderInfoEntity.getTotalPrice());
    }
}