package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.AuthUserDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.AuthUserConverter;
import com.github.AlGrom13.apps.dao.entity.AuthUserEntity;
import com.github.AlGrom13.apps.model.AuthUser;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;

public class DefaultAuthUserDao implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class DefaultAuthUserDaoHolder {
        static final DefaultAuthUserDao INSTANCE = new DefaultAuthUserDao();
    }

    public static DefaultAuthUserDao getInstance() {
        return DefaultAuthUserDao.DefaultAuthUserDaoHolder.INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        AuthUserEntity authUserEntity;
        try {
            Session session = HibernateUtil.getSession();
            authUserEntity = (AuthUserEntity) session
                    .createQuery("from AuthUserEntity a where a.login = :login")
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("auth_user not found by login: {}", login);
            authUserEntity = null;
        }
        return AuthUserConverter.fromEntity(authUserEntity);
    }

    @Override
    public Long saveAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(authUserEntity);
        session.getTransaction().commit();
        return authUserEntity.getId();
    }

    @Override
    public void updateAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(authUserEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(session.merge(authUserEntity));
        session.getTransaction().commit();
    }
}
