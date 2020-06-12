package com.github.AlGrom13.apps.dao.impl;

import com.github.AlGrom13.apps.dao.ClientDao;
import com.github.AlGrom13.apps.dao.HibernateUtil;
import com.github.AlGrom13.apps.dao.entity.CarEntity;
import com.github.AlGrom13.apps.dao.entity.CarOrderEntity;
import com.github.AlGrom13.apps.dao.entity.ClientEntity;
import com.github.AlGrom13.apps.dao.entity.ClientPersonalDataEntity;
import com.github.AlGrom13.apps.model.Client;
import com.github.AlGrom13.apps.model.ClientPersonalData;
import com.github.AlGrom13.apps.model.Sex;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultClientDaoTest {
    private ClientDao clientDao = DefaultClientDao.getInstance();

    @Test
    void getById() {
    }

    @Test
    void getAllClients() {
    }

    @Test
    void getClientCarOrders() {
    }

    @Test
    void getRentedCars() {
    }

    @Test
    void saveClient() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }

    ClientEntity createTestClientEntity(Long id) {
        ClientEntity clientEntity = new ClientEntity();
        ClientPersonalDataEntity clientPersonalDataEntity = new ClientPersonalDataEntity();
        clientPersonalDataEntity.setClientEntity(clientEntity);
        clientEntity.setLastName("testLastName1");
        clientEntity.setFirstName("testFirstName1");
        clientEntity.setSex(Sex.FEMALE);
        clientEntity.setClientPersonalDataEntity(clientPersonalDataEntity);
        clientEntity.setOrders(new ArrayList<CarOrderEntity>());

        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("car-" + id);

        CarOrderEntity carOrderEntity = new CarOrderEntity();
        carOrderEntity.setClientEntity(clientEntity);


        return clientEntity;
    }
}