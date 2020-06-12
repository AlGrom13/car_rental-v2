package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.AuthUserEntity;
import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.model.AuthUser;
import com.github.AlGrom13.apps.model.Client;

public class AuthUserConverter {

    public static AuthUser fromEntity(AuthUserEntity authUserEntity) {
        if (authUserEntity == null) {
            return null;
        } else {
            Client client = ClientConverter.fromEntity(authUserEntity.getClientEntity());
            AuthUser authUser = new AuthUser(
                    authUserEntity.getId(),
                    authUserEntity.getLogin(),
                    authUserEntity.getPassword(),
                    authUserEntity.getRole(),
                    client
            );
            client.setAuthUser(authUser);
            return authUser;
        }
    }

    public static AuthUserEntity toEntity(AuthUser authUser) {
        if (authUser == null) {
            return null;
        } else {
            AuthUserEntity authUserEntity = new AuthUserEntity();
            authUserEntity.setId(authUser.getId());
            authUserEntity.setLogin(authUser.getLogin());
            authUserEntity.setPassword(authUser.getPassword());
            authUserEntity.setRole(authUser.getRole());
            ClientEntity clientEntity = ClientConverter.toEntity(authUser.getClient());
            authUserEntity.setClientEntity(clientEntity);
            clientEntity.setAuthUserEntity(authUserEntity);
            return authUserEntity;
        }
    }
}
