package com.github.AlGrom13.apps.dao.entity;

import com.github.AlGrom13.apps.model.Sex;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_user_id")
    private AuthUserEntity authUserEntity;

    @OneToOne(mappedBy = "clientEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ClientPersonalDataEntity clientPersonalDataEntity;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "clients_cars",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")}
    )
    private List<CarEntity> rentedCars;

    @OneToMany(mappedBy = "clientEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<CarOrderEntity> orders;

    public ClientEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    public ClientPersonalDataEntity getClientPersonalDataEntity() {
        return clientPersonalDataEntity;
    }

    public void setClientPersonalDataEntity(ClientPersonalDataEntity clientPersonalDataEntity) {
        this.clientPersonalDataEntity = clientPersonalDataEntity;
    }

    public List<CarEntity> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(List<CarEntity> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public List<CarOrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<CarOrderEntity> orders) {
        this.orders = orders;
    }
}
