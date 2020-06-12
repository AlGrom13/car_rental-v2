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
        final AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(authUser.getId());
        adminEntity.setLogin(authUser.getLogin());
        adminEntity.setPassword(authUser.getPassword());
        adminEntity.setRole(authUser.getRole());
        return adminEntity;
    }
}
