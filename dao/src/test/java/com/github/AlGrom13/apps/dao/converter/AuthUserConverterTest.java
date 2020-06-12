package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.AuthUserEntity;
import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserConverterTest {

    @Test
    void fromEntity() {
        AuthUserEntity authUserEntity = new AuthUserEntity();
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientPersonalDataEntity(new ClientPersonalDataEntity());
        authUserEntity.setId(1l);
        authUserEntity.setLogin("test");
        authUserEntity.setPassword("test");
        authUserEntity.setRole(Role.CLIENT);
        authUserEntity.setClientEntity(clientEntity);

        AuthUser authUser = AuthUserConverter.fromEntity(authUserEntity);

        assertNotNull(authUser);
        assertNotNull(authUser.getClient());
        assertEquals(Client.class, authUser.getClient().getClass());
        assertEquals(authUserEntity.getId(), authUser.getId());
        assertEquals(authUserEntity.getLogin(), authUser.getLogin());
        assertEquals(authUserEntity.getPassword(), authUser.getPassword());
        assertEquals(authUserEntity.getRole(), authUser.getRole());
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
        client.setClientPersonalData(clientPersonalData);
        AuthUser authUser = new AuthUser(
                1l,
                "login",
                "pass",
                Role.CLIENT,
                client
        );

        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);

        assertNotNull(authUserEntity);
        assertNotNull(authUserEntity.getClientEntity());
        assertEquals(ClientEntity.class, authUserEntity.getClientEntity().getClass());
        assertEquals(authUser.getId(), authUserEntity.getId());
        assertEquals(authUser.getLogin(), authUserEntity.getLogin());
        assertEquals(authUser.getPassword(), authUserEntity.getPassword());
        assertEquals(authUser.getRole(), authUserEntity.getRole());
    }
}