package com.github.AlGrom13.apps.dao;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory = null;

    public static Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

    private static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("app.dao");
        }
        return entityManagerFactory.createEntityManager();
    }


    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
