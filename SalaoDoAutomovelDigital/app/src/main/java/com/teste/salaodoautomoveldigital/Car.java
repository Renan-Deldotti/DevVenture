package com.teste.salaodoautomoveldigital;

import android.graphics.Bitmap;

public class Car {
    private Bitmap carPhoto;
    private String carName, carPower, carDate;

    public Car(Bitmap carPhoto, String carName, String carPower, String carDate) {
        this.carPhoto = carPhoto;
        this.carName = carName;
        this.carPower = carPower;
        this.carDate = carDate;
    }

    public Bitmap getCarPhoto() {
        return carPhoto;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarPower() {
        return carPower;
    }

    public String getCarDate() {
        return carDate;
    }
}
