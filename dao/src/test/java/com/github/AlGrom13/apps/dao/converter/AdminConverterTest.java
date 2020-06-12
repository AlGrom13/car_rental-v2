package com.github.AlGrom13.apps.dao.converter;

import com.github.AlGrom13.apps.dao.entity.AdminEntity;
import com.github.AlGrom13.apps.dao.entity.AuthUserEntity;
import com.github.AlGrom13.apps.model.AuthUser;
import com.github.AlGrom13.apps.model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminConverterTest {

    @Test
    void fromEntityNull() {
        AuthUser admin = AdminConverter.fromEntity(null);
        assertNull(admin);
    }

    @Test
    void fromEntityNotNull() {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(1l);
        adminEntity.setLogin("testAdmin");
        adminEntity.setPassword("testPass");
        adminEntity.setRole(Role.ADMIN);

        AuthUser admin = AdminConverter.fromEntity(adminEntity);

        assertNotNull(admin);
        assertEquals(adminEntity.getId(), admin.getId());
        assertEquals(adminEntity.getLogin(), admin.getLogin());
        assertEquals(adminEntity.getPassword(), admin.getPassword());
        assertEquals(adminEntity.getRole(), admin.getRole());
        assertNull(admin.getClient());
    }

    @Test
    void toEntityNull() {
        AdminEntity authUserEntity = AdminConverter.toEntity(null);
        assertNull(authUserEntity);
    }

    @Test
    void toEntityNotNull() {
        AuthUser admin = new AuthUser(1l, "testLogin", "testPass", Role.ADMIN, null);

        AdminEntity adminEntity = AdminConverter.toEntity(admin);

        assertNotNull(adminEntity);
        assertEquals(admin.getId(), adminEntity.getId());
        assertEquals(admin.getLogin(), adminEntity.getLogin());
        assertEquals(admin.getPassword(), adminEntity.getPassword());
        assertEquals(admin.getRole(), adminEntity.getRole());
    }
}