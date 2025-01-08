package fr.mrsunshine.objects;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String requiredDate = formatter.format(this.getRegistration_date());

        return String.format(
                "<green>#%s <reset>- %s %s immatriculé le %s possède une benne de %s mètres cube.",
                this.getCode(),
                this.getBrand(),
                this.getModel(),
                requiredDate,
                this.getDumpSize()
        );
    }
}
