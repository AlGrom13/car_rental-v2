package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.CarOrderInfoEntity;
import com.github.AlGrom13.apps.model.CarOrderInfo;

public class CarOrderInfoConverter {

    public static CarOrderInfo fromEntity(CarOrderInfoEntity carOrderInfoEntity) {
        if (carOrderInfoEntity == null) {
            return null;
        } else {
            CarOrderInfo carOrderInfo = new CarOrderInfo();
            carOrderInfo.setBeginDate(carOrderInfoEntity.getBeginDate());
            carOrderInfo.setEndDate(carOrderInfoEntity.getEndDate());
            carOrderInfo.setTotalPrice(carOrderInfoEntity.getTotalPrice());
            return carOrderInfo;
        }
    }

    public static CarOrderInfoEntity toEntity(CarOrderInfo carOrderInfo) {
        if (carOrderInfo == null) {
            return null;
        } else {
            CarOrderInfoEntity carOrderInfoEntity = new CarOrderInfoEntity();
            carOrderInfoEntity.setBeginDate(carOrderInfo.getBeginDate());
            carOrderInfoEntity.setEndDate(carOrderInfo.getEndDate());
            carOrderInfoEntity.setTotalPrice(carOrderInfo.getTotalPrice());
            return carOrderInfoEntity;
        }
    }
}
