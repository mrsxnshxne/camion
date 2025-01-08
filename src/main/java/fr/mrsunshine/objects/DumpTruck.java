package fr.mrsunshine.objects;


import fr.mrsunshine.utils.DateUtils;

import java.util.Date;

public class DumpTruck extends Truck {

    private int dumpSize;


    public DumpTruck(int code, String model, String brand, Date registration_date, int dumpSize) {
        super(code, model, brand, registration_date);
        this.dumpSize = dumpSize;
    }


    public int getDumpSize() {
        return dumpSize;
    }

    public void setDumpSize(int dumpSize) {
        this.dumpSize = dumpSize;
    }


    @Override
    public String toString() {
        return String.format(
                "<green>[BENNE] #%s <reset>- %s %s immatriculé le %s possède une benne de %s mètres cube.",
                this.getCode(),
                this.getBrand(),
                this.getModel(),
                DateUtils.formatDateObject(this.getRegistration_date()),
                this.getDumpSize()
        );
    }
}
