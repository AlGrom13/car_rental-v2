package com.github.AlGrom13.apps.dao.entity;

import com.github.AlGrom13.apps.model.CarOrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "car_order")
public class CarOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

    @OneToOne(mappedBy = "carOrderEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CarOrderInfoEntity carOrderInfoEntity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CarOrderStatus carOrderStatus;

    public CarOrderEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    public CarOrderInfoEntity getCarOrderInfoEntity() {
        return carOrderInfoEntity;
    }

    public void setCarOrderInfoEntity(CarOrderInfoEntity carOrderInfoEntity) {
        this.carOrderInfoEntity = carOrderInfoEntity;
    }

    public CarOrderStatus getCarOrderStatus() {
        return carOrderStatus;
    }

    public void setCarOrderStatus(CarOrderStatus carOrderStatus) {
        this.carOrderStatus = carOrderStatus;
    }
}
