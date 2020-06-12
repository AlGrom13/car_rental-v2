package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.ClientPersonalData;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClientPersonalDataConverterTest {

    @Test
    void fromEntity() {
        ClientPersonalDataEntity clientPersonalDataEntity = new ClientPersonalDataEntity();
        clientPersonalDataEntity.setId(1l);
        clientPersonalDataEntity.setDateOfBirth(LocalDateTime.now());
        clientPersonalDataEntity.setPassportNumber("12345");
        clientPersonalDataEntity.setNationality("nation");
        clientPersonalDataEntity.setValidityDate(LocalDateTime.now());

        ClientPersonalData clientPersonalData = ClientPersonalDataConverter.fromEntity(clientPersonalDataEntity);

        assertNotNull(clientPersonalData);
        assertEquals(clientPersonalDataEntity.getId(), clientPersonalData.getId());
        assertEquals(clientPersonalDataEntity.getDateOfBirth(), clientPersonalData.getDateOfBirth());
        assertEquals(clientPersonalDataEntity.getNationality(), clientPersonalData.getNationality());
        assertEquals(clientPersonalDataEntity.getPassportNumber(), clientPersonalData.getPassportNumber());
        assertEquals(clientPersonalDataEntity.getValidityDate(), clientPersonalData.getValidityDate());
    }

    @Test
    void toEntity() {
        ClientPersonalData clientPersonalData = new ClientPersonalData(
                1l,
                LocalDateTime.now(),
                "nation",
                "number",
                LocalDateTime.now(),
                null
        );

        ClientPersonalDataEntity clientPersonalDataEntity = ClientPersonalDataConverter.toEntity(clientPersonalData);

        assertNotNull(clientPersonalDataEntity);
        assertEquals(clientPersonalData.getId(), clientPersonalDataEntity.getId());
        assertEquals(clientPersonalData.getDateOfBirth(), clientPersonalDataEntity.getDateOfBirth());
        assertEquals(clientPersonalData.getNationality(), clientPersonalDataEntity.getNationality());
        assertEquals(clientPersonalData.getPassportNumber(), clientPersonalDataEntity.getPassportNumber());
        assertEquals(clientPersonalData.getValidityDate(), clientPersonalDataEntity.getValidityDate());
    }
}