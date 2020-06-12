package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.CarDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.converter.CarConverter;
import com.github.AlGrom13.apps.dao.converter.CarOrderConverter;
import com.github.AlGrom13.apps.dao.converter.ClientConverter;
import com.github.AlGrom13.apps.dao.entity.CarEntity;
import com.github.AlGrom13.apps.dao.entity.CarOrderEntity;
import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.model.Car;
import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.Client;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultCarDao implements CarDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class DefaultCarDaoHolder {
        static final DefaultCarDao INSTANCE = new DefaultCarDao();
    }

    public static DefaultCarDao getInstance() {
        return DefaultCarDao.DefaultCarDaoHolder.INSTANCE;
    }

    @Override
    public Car getById(Long carId) {
        CarEntity carEntity;
        try {
            carEntity = (CarEntity) HibernateUtil.getSession()
                    .createQuery("from CarEntity c where c.id = :id")
                    .setParameter("id", carId)
                    .getSingleResult();
            return CarConverter.fromEntity(carEntity);
        } catch (NoResultException e) {
            log.info("car not found by id: {}", carId);
            return null;
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<CarEntity> carEntityList = HibernateUtil.getSession()
                .createQuery("from CarEntity").list();
        return carEntityList.stream()
                .map(CarConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarOrder> getOrders(Long carId) {
        Session session = HibernateUtil.getSession();
        CarEntity carEntity = session.find(CarEntity.class, carId);
        return carEntity.getOrders().stream()
                .map(CarOrderConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> getClients(Long carId) {
        Session session = HibernateUtil.getSession();
        CarEntity carEntity = session.find(CarEntity.class, carId);
        return carEntity.getClients().stream()
                .map(ClientConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCar(Car car) {
        CarEntity carEntity = CarConverter.toEntity(car);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(carEntity);
        session.getTransaction().commit();
    }

    @Override
    public void updateCar(Car car) {
        CarEntity carEntity = CarConverter.toEntity(car);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(carEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteCar(Long carId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        CarEntity carEntity = session.find(CarEntity.class, carId);
        session.delete(carEntity);
        session.getTransaction().commit();
    }
}
