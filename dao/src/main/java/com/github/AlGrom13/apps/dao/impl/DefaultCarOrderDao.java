package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.CarOrderDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.CarOrderConverter;
import com.github.AlGrom13.apps.dao.entity.CarOrderEntity;
import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.CarOrderStatus;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCarOrderDao implements CarOrderDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class DefaultCarOrderDaoHolder {
        static final DefaultCarOrderDao INSTANCE = new DefaultCarOrderDao();
    }

    public static DefaultCarOrderDao getInstance() {
        return DefaultCarOrderDao.DefaultCarOrderDaoHolder.INSTANCE;
    }

    @Override
    public CarOrder getCarOrderById(Long carOrderId) {
        CarOrderEntity carOrderEntity;
        try {
            carOrderEntity = (CarOrderEntity) HibernateUtil.getSession()
                    .createQuery("from CarOrderEntity co where co.id = :id")
                    .setParameter("id", carOrderId)
                    .getSingleResult();
            return CarOrderConverter.fromEntity(carOrderEntity);
        } catch (NoResultException e) {
            log.info("car order not found by id: {}", carOrderId);
            return null;
        }
    }

    @Override
    public List<CarOrder> getAllCarOrders() {
        List<CarOrderEntity> carOrderEntityList = HibernateUtil.getSession()
                .createQuery("from CarOrderEntity ").list();
        return carOrderEntityList.stream()
                .map(CarOrderConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCarOrder(CarOrder carOrder) {
        CarOrderEntity carOrderEntity = CarOrderConverter.toEntity(carOrder);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(carOrderEntity);
        session.getTransaction().commit();
    }

    @Override
    public void updateCarOrder(CarOrder carOrder) {
        CarOrderEntity carOrderEntity = CarOrderConverter.toEntity(carOrder);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(carOrderEntity);
        session.getTransaction().commit();
    }

    @Override
    public void updateCarOrderStatus(Long carOrderId, CarOrderStatus carOrderStatus) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        CarOrderEntity carOrderEntity = session.find(CarOrderEntity.class, carOrderId);
        carOrderEntity.setCarOrderStatus(carOrderStatus);
        session.saveOrUpdate(carOrderEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteCarOrderById(Long carOrderId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        CarOrderEntity carOrderEntity = session.find(CarOrderEntity.class, carOrderId);
        session.delete(carOrderEntity);
        session.getTransaction().commit();
    }
}
