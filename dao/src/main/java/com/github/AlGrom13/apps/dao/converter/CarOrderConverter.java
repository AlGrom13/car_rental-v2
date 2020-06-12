package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.CarEntity;
import com.github.AlGrom13.apps.dao.entity.CarOrderEntity;
import com.github.AlGrom13.apps.dao.entity.CarOrderInfoEntity;
import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.model.Car;
import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.CarOrderInfo;
import com.github.AlGrom13.apps.model.Client;

public class CarOrderConverter {

    public static CarOrder fromEntity(CarOrderEntity carOrderEntity) {
        if (carOrderEntity == null) {
            return null;
        } else {
            CarOrderInfo carOrderInfo = CarOrderInfoConverter.fromEntity(carOrderEntity.getCarOrderInfoEntity());
            Client client = ClientConverter.fromEntity(carOrderEntity.getClientEntity());
            Car car = CarConverter.fromEntity(carOrderEntity.getCarEntity());
            return new CarOrder(
                    carOrderEntity.getId(),
                    client,
                    car,
                    carOrderInfo,
                    carOrderEntity.getCarOrderStatus()
            );
        }
    }

    public static CarOrderEntity toEntity(CarOrder carOrder) {
        if (carOrder == null) {
            return null;
        } else {
            CarOrderEntity carOrderEntity = new CarOrderEntity();
            ClientEntity clientEntity = ClientConverter.toEntity(carOrder.getClient());
            CarEntity carEntity = CarConverter.toEntity(carOrder.getCar());
            CarOrderInfoEntity carOrderInfoEntity = CarOrderInfoConverter.toEntity(carOrder.getCarOrderInfo());

            carOrderEntity.setId(carOrder.getCarOrderId());
            carOrderEntity.setClientEntity(clientEntity);
            carOrderEntity.setCarEntity(carEntity);
            carOrderEntity.setCarOrderInfoEntity(carOrderInfoEntity);
            carOrderEntity.setCarOrderStatus(carOrder.getCarOrderStatus());

            return carOrderEntity;
        }
    }
}
