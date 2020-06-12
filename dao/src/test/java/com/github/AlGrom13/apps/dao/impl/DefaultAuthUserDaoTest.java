package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.AuthUserDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.AuthUserConverter;
import com.github.AlGrom13.apps.dao.entity.AuthUserEntity;
import com.github.AlGrom13.apps.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAuthUserDaoTest {
    private AuthUserDao dao = new DefaultAuthUserDao();

    @Test
    void getByLogin() {
        Client testClient = new Client(null, "LastName", "FirstName", Sex.MALE, null);
        ClientPersonalData clientPersonalData = new ClientPersonalData(testClient);
        testClient.setClientPersonalData(clientPersonalData);
        AuthUser testUser = new AuthUser(null, "testUser", "testUser", Role.CLIENT, testClient);
        testClient.setAuthUser(testUser);
        addTestDataToDB(testUser);

        AuthUser userFromDB = dao.getByLogin("testUser");

        assertNotNull(userFromDB);
        assertEquals(userFromDB.getPassword(), testUser.getPassword());
    }

    @Test
    void saveAuthUser() {
        Client testClient = new Client(null, "LastName2", "FirstName2", Sex.MALE, null);
        ClientPersonalData clientPersonalData = new ClientPersonalData(testClient);
        testClient.setClientPersonalData(clientPersonalData);
        AuthUser testUser = new AuthUser(null, "testUser2", "testUser2", Role.CLIENT, testClient);
        testClient.setAuthUser(testUser);

        long savedUserId = dao.saveAuthUser(testUser);

        AuthUserEntity authUserEntityFromDB = HibernateUtil.getSession().get(AuthUserEntity.class, savedUserId);

        assertNotNull(authUserEntityFromDB);
        assertEquals(authUserEntityFromDB.getPassword(), testUser.getPassword());
        assertNotNull(authUserEntityFromDB.getClientEntity());
    }

    @Test
    void updateAuthUser() {
        String login = "testUser3";
        String password = "pass123";
        String newPassword = "newPass123";
        Client testClient = new Client(null, "LastName", "FirstName", Sex.MALE, null);
        ClientPersonalData clientPersonalData = new ClientPersonalData(testClient);
        testClient.setClientPersonalData(clientPersonalData);
        AuthUser testUser = new AuthUser(null, login, password, Role.CLIENT, testClient);
        testClient.setAuthUser(testUser);
        dao.saveAuthUser(testUser);
        AuthUser userFromDB = dao.getByLogin(login);

        userFromDB.setPassword(newPassword);
        userFromDB.getClient().setFirstName("newFirstName");
        dao.updateAuthUser(userFromDB);
        AuthUserEntity authUserEntityFromDB = (AuthUserEntity) HibernateUtil.getSession()
                .createQuery("from AuthUserEntity a where a.login = :login")
                .setParameter("login", testUser.getLogin())
                .getSingleResult();

        assertEquals(newPassword, authUserEntityFromDB.getPassword());
        assertEquals("newFirstName", authUserEntityFromDB.getClientEntity().getFirstName());
    }

    @Test
    void deleteAuthUser() {
        String login = "testUser4";
        Client testClient = new Client(null, "LastName4", "FirstName4", Sex.MALE, null);
        ClientPersonalData clientPersonalData = new ClientPersonalData(testClient);
        testClient.setClientPersonalData(clientPersonalData);
        AuthUser testUser = new AuthUser(null, login, "testUser4", Role.CLIENT, testClient);
        testClient.setAuthUser(testUser);
        dao.saveAuthUser(testUser);
        AuthUser userFromDB = dao.getByLogin(login);

        dao.deleteAuthUser(userFromDB);

        assertThrows(NoResultException.class, () -> HibernateUtil.getSession()
                .createQuery("from AuthUserEntity a where a.login = :login")
                .setParameter("login", testUser.getLogin())
                .getSingleResult()
        );
    }

    void addTestDataToDB(AuthUser... users) {
        AuthUserEntity authUserEntity;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for (AuthUser user : users) {
            authUserEntity = AuthUserConverter.toEntity(user);
            session.save(authUserEntity);
        }
        session.getTransaction().commit();
    }
}