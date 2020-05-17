package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.AdminDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.AdminConverter;
import com.github.AlGrom13.apps.dao.entity.AdminEntity;
import com.github.AlGrom13.apps.model.AuthUser;
import com.github.AlGrom13.apps.model.Role;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAdminDaoTest {
    private AdminDao dao = DefaultAdminDao.getInstance();

    @Test
    void getByLoginIfExists() {
        AuthUser admin = new AuthUser(null, "testAdmin", "testAdmin", Role.ADMIN, null);
        addTestDataToDB(admin);

        AuthUser adminFromDB = dao.getByLogin("testAdmin");
        assertNotNull(adminFromDB);
        assertEquals(adminFromDB.getPassword(), admin.getPassword());

        deleteTestDateFromDB(adminFromDB);
    }

    @Test
    void getByLoginIfNotExists() {
        String login = "AdminNotExists";

        AuthUser adminFromDB = dao.getByLogin(login);

        assertNull(adminFromDB);
    }

    @Test
    void saveNewAdmin() {
        AuthUser admin = new AuthUser(null, "testAdmin2", "testAdmin2", Role.ADMIN, null);

        long adminId = dao.saveAdmin(admin);

        AdminEntity adminEntityFromDB = HibernateUtil.getSession().get(AdminEntity.class, adminId);
        assertNotNull(adminEntityFromDB);
        assertEquals(admin.getLogin(), adminEntityFromDB.getLogin());
        assertEquals(admin.getPassword(), adminEntityFromDB.getPassword());

        deleteTestDateFromDB(admin);
    }

    @Test
    void changePassword() {
        String adminLogin = "testAdmin3";
        String firstAdminPass = "testAdmin3";
        String secondAdminPass = "qwe123";
        AuthUser admin = new AuthUser(null, adminLogin, firstAdminPass, Role.ADMIN, null);
        addTestDataToDB(admin);

        dao.changePassword(adminLogin, secondAdminPass);
        AdminEntity adminEntityFromDB = (AdminEntity) HibernateUtil.getSession()
                .createQuery("from AdminEntity a where a.login = :login")
                .setParameter("login", admin.getLogin())
                .getSingleResult();
        assertEquals(secondAdminPass, adminEntityFromDB.getPassword());

        deleteTestDateFromDB(admin);
    }

    @Test
    void deleteByLogin() {
        String adminLogin = "adminLogin";
        AuthUser admin = new AuthUser(null, adminLogin, "adminPass", Role.ADMIN, null);
        addTestDataToDB(admin);

        dao.deleteByLogin(adminLogin);

        assertThrows(NoResultException.class, () -> HibernateUtil.getSession()
                .createQuery("from AdminEntity a where a.login = :login")
                .setParameter("login", adminLogin)
                .getSingleResult()
        );

    }

    void addTestDataToDB(AuthUser... admins) {
        AdminEntity adminEntity;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for (AuthUser admin : admins) {
            adminEntity = AdminConverter.toEntity(admin);
            session.save(adminEntity);
        }
        session.getTransaction().commit();
    }

    void deleteTestDateFromDB(AuthUser... admins) {
        AdminEntity adminEntity;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for (AuthUser admin : admins) {
            session.createQuery("delete AdminEntity where login = :login")
                    .setParameter("login", admin.getLogin())
                    .executeUpdate();
        }
        session.getTransaction().commit();
    }
}