package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.Client;
import com.github.AlGrom13.apps.model.ClientPersonalData;
import com.github.AlGrom13.apps.model.Sex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientConverterTest {

    @Test
    void fromEntity() {
        ClientEntity clientEntity = new ClientEntity();
        ClientPersonalDataEntity clientPersonalDataEntity = new ClientPersonalDataEntity();
        clientEntity.setId(1l);
        clientEntity.setFirstName("test");
        clientEntity.setLastName("test");
        clientEntity.setSex(Sex.FEMALE);
        clientEntity.setClientPersonalDataEntity(clientPersonalDataEntity);

        Client client = ClientConverter.fromEntity(clientEntity);

        assertNotNull(client);
        assertEquals(clientEntity.getId(), client.getId());
        assertEquals(clientEntity.getFirstName(), client.getFirstName());
        assertEquals(clientEntity.getLastName(), client.getLastName());
        assertEquals(clientEntity.getSex(), client.getSex());
        assertNotNull(client.getClientPersonalData());
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

        ClientEntity clientEntity = ClientConverter.toEntity(client);

        assertNotNull(clientEntity);
        assertEquals(client.getId(), clientEntity.getId());
        assertEquals(client.getFirstName(), clientEntity.getFirstName());
        assertEquals(client.getLastName(), clientEntity.getLastName());
        assertEquals(client.getSex(), clientEntity.getSex());
        assertNotNull(clientEntity.getClientPersonalDataEntity());
    }
}