package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.AdminDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.AdminConverter;
import com.github.AlGrom13.apps.dao.entity.AdminEntity;
import com.github.AlGrom13.apps.model.AuthUser;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

public class DefaultAdminDao implements AdminDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAdminDao.class);

    private static class DefaultAdminDaoHolder {
        static final DefaultAdminDao INSTANCE = new DefaultAdminDao();
    }

    public static DefaultAdminDao getInstance() {
        return DefaultAdminDao.DefaultAdminDaoHolder.INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        AdminEntity adminEntity;
        try {
            adminEntity = (AdminEntity) HibernateUtil.getSession()
                    .createQuery("from AdminEntity a where a.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("admin not found by login: {}", login);
            adminEntity = null;
        }
        return AdminConverter.fromEntity(adminEntity);
    }

    @Override
    public Long saveAdmin(AuthUser admin) {
        AdminEntity adminEntity = AdminConverter.toEntity(admin);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(adminEntity);
        session.getTransaction().commit();
        return adminEntity.getId();
    }

    @Override
    public void changePassword(String login, String password) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.createQuery("update AdminEntity set password= :password where login = :login")
                .setParameter("password", password)
                .setParameter("login", login)
                .executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void deleteByLogin(String login) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.createQuery("delete AdminEntity where login = :login")
                .setParameter("login", login)
                .executeUpdate();
        session.getTransaction().commit();
    }
}
