package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.*;
import com.github.AlGrom13.apps.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarOrderConverterTest {

    @Test
    void fromEntity() {
        CarOrderEntity carOrderEntity = new CarOrderEntity();
        carOrderEntity.setId(1l);
        carOrderEntity.setCarOrderStatus(CarOrderStatus.PROCESSING);
        CarEntity carEntity = new CarEntity();
        carOrderEntity.setCarEntity(carEntity);
        CarOrderInfoEntity carOrderInfoEntity = new CarOrderInfoEntity();
        carOrderEntity.setCarOrderInfoEntity(carOrderInfoEntity);
        ClientEntity clientEntity = new ClientEntity();
        ClientPersonalDataEntity clientPersonalDataEntity = new ClientPersonalDataEntity();
        clientEntity.setClientPersonalDataEntity(clientPersonalDataEntity);
        carOrderEntity.setClientEntity(clientEntity);

        CarOrder carOrder = CarOrderConverter.fromEntity(carOrderEntity);

        assertNotNull(carOrder);
        assertEquals(carOrderEntity.getId(), carOrder.getCarOrderId());
        assertNotNull(carOrder.getCarOrderInfo());
        assertNotNull(carOrder.getCar());
        assertNotNull(carOrder.getClient());
        assertEquals(carOrderEntity.getCarOrderStatus(), carOrder.getCarOrderStatus());
    }

    @Test
    void toEntity() {
        Client client = new Client(
            1l,
                "test",
                "test",
                Sex.FEMALE,
                null
        );
        ClientPersonalData clientPersonalData = new ClientPersonalData(client);
        clientPersonalData.setClient(client);
        client.setClientPersonalData(clientPersonalData);
        Car car = new Car(
                1l,
                "brand",
                "model",
                "date",
                100
        );
        CarOrder carOrder = new CarOrder(
                1l,
                client,
                car,
                new CarOrderInfo(),
                CarOrderStatus.PROCESSING
        );

        CarOrderEntity carOrderEntity = CarOrderConverter.toEntity(carOrder);

        assertNotNull(carOrderEntity);
        assertEquals(carOrder.getCarOrderId(), carOrderEntity.getId());
        assertNotNull(carOrderEntity.getClientEntity());
        assertNotNull(carOrderEntity.getCarEntity());
        assertNotNull(carOrderEntity.getCarOrderInfoEntity());
        assertEquals(carOrder.getCarOrderStatus(), carOrderEntity.getCarOrderStatus());
    }
}