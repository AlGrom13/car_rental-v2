package com.github.AlGrom13.apps.model;

public class Car {
    private Long carId;
    private String brand;
    private String model;
    private String releaseDate;
    private int pricePerDay;

    public Car(Long carId, String brand, String model, String releaseDate, int pricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.releaseDate = releaseDate;
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }
}
