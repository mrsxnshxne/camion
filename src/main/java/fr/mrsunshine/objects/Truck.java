package fr.mrsunshine.objects;


import java.util.Date;

public abstract class Truck {

    private int code;
    private String model;
    private String brand;
    private Date registration_date;


    public Truck(int code, String model, String brand, Date registration_date) {
        this.code = code;
        this.model = model;
        this.brand = brand;
        this.registration_date = registration_date;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
