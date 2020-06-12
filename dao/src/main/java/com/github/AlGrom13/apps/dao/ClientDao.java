package com.github.AlGrom13.apps.dao;

import com.github.AlGrom13.apps.model.Car;
import com.github.AlGrom13.apps.model.CarOrder;
import com.github.AlGrom13.apps.model.Client;

import java.util.List;

public interface ClientDao {

    Client getById(Long clientId);

    List<Client> getAllClients();

    List<CarOrder> getClientCarOrders(Long clientId);

    List<Car> getRentedCars(Long clientId);

    Long saveClient(Client client);

    void updateClient(Client client);

    void deleteClient(Long clientId);
}
