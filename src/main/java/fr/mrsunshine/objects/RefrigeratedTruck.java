package fr.mrsunshine.objects;


import fr.mrsunshine.utils.DateUtils;

import java.util.Date;

public class RefrigeratedTruck extends Truck {

    private int holdTemperature;


    public RefrigeratedTruck(int code, String model, String brand, Date registrationDate, int holdTemperature) {
        super(code, model, brand, registrationDate);
        this.holdTemperature = holdTemperature;
    }


    public int getHoldTemperature() {
        return holdTemperature;
    }

    public void setHoldTemperature(int holdTemperature) {
        this.holdTemperature = holdTemperature;
    }


    @Override
    public String toString() {
        return String.format(
                "<blue>[FRIGO] #%s <reset>- %s %s immatriculé le %s possède une soute à %s degrés.",
                this.getCode(),
                this.getBrand(),
                this.getModel(),
                DateUtils.formatDateObject(this.getRegistrationDate()),
                this.getHoldTemperature()
        );
    }
}
