package fr.mrsunshine.objects;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RefrigeratedTruck extends Truck {

    private int holdTemperature;


    public RefrigeratedTruck(int code, String model, String brand, Date registration_date, int holdTemperature) {
        super(code, model, brand, registration_date);
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

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String requiredDate = formatter.format(this.getRegistration_date());

        return String.format(
                "<blue>#%s <reset>- %s %s immatriculé le %s possède une soute à %s degrés.",
                this.getCode(),
                this.getBrand(),
                this.getModel(),
                requiredDate,
                this.getHoldTemperature()
        );
    }
}
