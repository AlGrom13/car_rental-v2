package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.ClientDao;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;


public class DefaultClientDao implements ClientDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    private static class DefaultClientDaoHolder {
        static final DefaultClientDao INSTANCE = new DefaultClientDao();
    }

    public static DefaultClientDao getInstance() {
        return DefaultClientDao.DefaultClientDaoHolder.INSTANCE;
    }


    @Override
    public Client getById(Long clientId) {
        ClientEntity clientEntity;
        try {
            clientEntity = (ClientEntity) HibernateUtil.getSession()
                    .createQuery("from ClientEntity c where c.id = :id")
                    .setParameter("id", clientId)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("client not found by id: {}", clientId);
            clientEntity = null;
        }
        return ClientConverter.fromEntity(clientEntity);
    }

    @Override
    public List<Client> getAllClients() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ClientEntity> criteria = criteriaBuilder.createQuery(ClientEntity.class);
        Root<ClientEntity> root = criteria.from(ClientEntity.class);
        criteria.select(root);
        List<ClientEntity> clientEntities = session.createQuery(criteria).getResultList();
        return clientEntities.stream()
                .map(clientEntity -> ClientConverter.fromEntity(clientEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarOrder> getClientCarOrders(Long clientId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ClientEntity clientEntity = session.find(ClientEntity.class, clientId);
        List<CarOrderEntity> orders = clientEntity.getOrders();
        session.getTransaction().commit();
        return orders.stream()
                .map(carOrderEntity -> CarOrderConverter.fromEntity(carOrderEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getRentedCars(Long clientId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ClientEntity clientEntity = session.find(ClientEntity.class, clientId);
        List<CarEntity> rentedCars = clientEntity.getRentedCars();
        session.getTransaction().commit();
        return rentedCars.stream()
                .map(carEntity -> CarConverter.fromEntity(carEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Long saveClient(Client client) {
        ClientEntity clientEntity = ClientConverter.toEntity(client);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(clientEntity);
        session.getTransaction().commit();
        return clientEntity.getId();
    }

    @Override
    public void updateClient(Client client) {
        ClientEntity clientEntity = ClientConverter.toEntity(client);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(clientEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteClient(Long clientId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ClientEntity clientEntity = session.find(ClientEntity.class, clientId);
        session.delete(clientEntity);
        session.getTransaction().commit();
    }
}
