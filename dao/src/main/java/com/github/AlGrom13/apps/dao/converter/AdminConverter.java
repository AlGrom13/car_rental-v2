package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.AdminEntity;
import com.github.AlGrom13.apps.model.AuthUser;

public class AdminConverter {

    public static AuthUser fromEntity(AdminEntity authUser) {
        if (authUser == null) {
            return null;
        }
        return new AuthUser(
                authUser.getId(),
                authUser.getLogin(),
                authUser.getPassword(),
                authUser.getRole(),
                null);
    }

    public static AdminEntity toEntity(AuthUser authUser) {
        if (authUser == null) {
            return null;
        }
        final AdminEntity authUserEntity = new AdminEntity();
        authUserEntity.setId(authUser.getId());
        authUserEntity.setLogin(authUser.getLogin());
        authUserEntity.setPassword(authUser.getPassword());
        authUserEntity.setRole(authUser.getRole());
        return authUserEntity;
    }
}
