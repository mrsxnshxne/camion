package fr.mrsunshine.objects;


import java.util.Date;

public abstract class Truck {

    private int code;
    private String model;
    private String brand;
    private Date registrationDate;


    public Truck(int code, String model, String brand, Date registrationDate) {
        this.code = code;
        this.model = model;
        this.brand = brand;
        this.registrationDate = registrationDate;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registration_date) {
        this.registrationDate = registration_date;
    }
}
