package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.ClientPersonalData;

public class ClientPersonalDataConverter {

    public static ClientPersonalData fromEntity(ClientPersonalDataEntity clientPersonalDataEntity) {
        if (clientPersonalDataEntity == null) {
           return null;
        } else {
            return new ClientPersonalData(
                    clientPersonalDataEntity.getId(),
                    clientPersonalDataEntity.getDateOfBirth(),
                    clientPersonalDataEntity.getNationality(),
                    clientPersonalDataEntity.getPassportNumber(),
                    clientPersonalDataEntity.getValidityDate(),
                    null
            );
        }
    }

    public static ClientPersonalDataEntity toEntity(ClientPersonalData clientPersonalData) {
        if (clientPersonalData == null) {
            return null;
        } else {
            ClientPersonalDataEntity clientPersonalDataEntity =
                    new ClientPersonalDataEntity();
            clientPersonalDataEntity.setId(clientPersonalData.getId());
            clientPersonalDataEntity.setDateOfBirth(clientPersonalData.getDateOfBirth());
            clientPersonalDataEntity.setNationality(clientPersonalData.getNationality());
            clientPersonalDataEntity.setPassportNumber(clientPersonalData.getPassportNumber());
            clientPersonalDataEntity.setValidityDate(clientPersonalData.getValidityDate());
            return clientPersonalDataEntity;
        }
    }
}
