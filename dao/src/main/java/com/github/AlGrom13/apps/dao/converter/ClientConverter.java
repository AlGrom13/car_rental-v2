package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.Client;
import com.github.AlGrom13.apps.model.ClientPersonalData;

public class ClientConverter {

    public static Client fromEntity(ClientEntity clientEntity) {
        if (clientEntity == null) {
            return null;
        } else {
            ClientPersonalData clientPersonalData =
                    ClientPersonalDataConverter.fromEntity(clientEntity.getClientPersonalDataEntity());
            Client client = new Client(
                    clientEntity.getId(),
                    clientEntity.getLastName(),
                    clientEntity.getFirstName(),
                    clientEntity.getSex(),
                    clientPersonalData
            );
            clientPersonalData.setClient(client);
            return client;
        }
    }

    public static ClientEntity toEntity(Client client) {
        if (client == null) {
            return null;
        } else {
            ClientEntity clientEntity = new ClientEntity();
            ClientPersonalDataEntity clientPersonalDataEntity =
                    ClientPersonalDataConverter.toEntity(client.getClientPersonalData());
            clientEntity.setId(client.getId());
            clientEntity.setLastName(client.getLastName());
            clientEntity.setFirstName(client.getFirstName());
            clientEntity.setSex(client.getSex());
            clientEntity.setClientPersonalDataEntity(clientPersonalDataEntity);
            clientPersonalDataEntity.setClientEntity(clientEntity);
            return clientEntity;
        }
    }
}
