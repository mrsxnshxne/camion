package fr.mrsunshine.instances;

import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.objects.DumpTruck;
import fr.mrsunshine.objects.RefrigeratedTruck;
import fr.mrsunshine.objects.Truck;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TruckHandler {

    private static final TruckHandler instance = new TruckHandler();


    private List<Truck> trucks = new ArrayList<>();


    public TruckHandler() { }


    // Instance

    public static TruckHandler getInstance() {
        return instance;
    }


    // Trucks

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    public void showTrucks() {
        for (Truck truck : trucks) {
            TerminalHandler.println(truck.toString());
        }
    }


    // Truck

    public Truck getTruck(int code) {
        for (Truck truck : trucks) {
            if (truck.getCode() == code) {
                return truck;
            }
        }
        return null;
    }

    public void addTruck(Truck truck) {
        if (truck == null) return;
        this.trucks.add(truck);
    }

    public void removeTruck(Truck truck) {
        if (truck == null) return;
        this.trucks.remove(truck);
    }


    // Refrigerated truck

    public void addRefrigeratedTruck() {
        try {
            int code = InputReader.readInt("Entrez le code du camion:");
            String model = InputReader.readString("Entrez le modèle du camion:");
            String brand = InputReader.readString("Entrez la marque du camion:");
            int registration_day = InputReader.readInt("Entrez le jour d'immatriculation:");
            int registration_month = InputReader.readInt("Entrez le mois d'immatriculation:");
            int registration_year = InputReader.readInt("Entrez l'année d'immatriculation:");
            int holdTemperature = InputReader.readInt("Entrez la temperature de la soute:");

            if (model == null || brand == null || code == -1 || registration_day == -1 || registration_month == -1 || registration_year == -1 || holdTemperature == -1) {
                throw new Exception();
            }

            RefrigeratedTruck refrigeratedTruck = new RefrigeratedTruck(code, model, brand, new Date(registration_year-1900, registration_month-1, registration_day), holdTemperature);
            this.addTruck(refrigeratedTruck);

            TerminalHandler.println("<green>Camion frigorifique ajouté avec succès.<reset>");

        } catch (Exception e) {
            TerminalHandler.invalidEntries();
        }
    }


    public void removeRefrigeratedTruck() {
        int code = InputReader.readInt("Numéro du camion frigorifique à supprimer:");

        if (code == -1) {
            TerminalHandler.invalidEntry();

        } else {
            Truck truck = this.getTruck(code);

            if (truck instanceof RefrigeratedTruck) {
                this.removeTruck(truck);
                TerminalHandler.println("<green>Camion frigorifique supprimé avec succès.<reset>");
            } else {
                TerminalHandler.println("<yellow>Ce camion n'est pas un camion frigorifique.<reset>");
            }
        }
    }


    public void showRefrigeratedTrucks() {
        for (Truck truck : trucks) {
            if (truck instanceof RefrigeratedTruck) {
                TerminalHandler.println(truck.toString());
            }
        }
    }


    // Dump truck

    public void addDumpTruck() {

        try {
            int code = InputReader.readInt("Entrez le code du camion:");
            String model = InputReader.readString("Entrez le modèle du camion:");
            String brand = InputReader.readString("Entrez la marque du camion:");
            int registration_day = InputReader.readInt("Entrez le jour d'immatriculation:");
            int registration_month = InputReader.readInt("Entrez le mois d'immatriculation:");
            int registration_year = InputReader.readInt("Entrez l'année d'immatriculation:");
            int holdSize = InputReader.readInt("Entrez le volume de la benne:");

            if (model == null || brand == null || code == -1 || registration_day == -1 || registration_month == -1 || registration_year == -1 || holdSize == -1) {
                throw new Exception();
            }

            DumpTruck dumpTruck = new DumpTruck(code, model, brand, new Date(registration_year-1900, registration_month-1, registration_day), holdSize);
            this.addTruck(dumpTruck);

            TerminalHandler.println("<green>Camion benne ajouté avec succès.<reset>");

        } catch (Exception e) {
            TerminalHandler.invalidEntries();
        }
    }


    public void removeDumpTruck() {
        int code = InputReader.readInt("Numéro du camion benne à supprimer:");

        if (code == -1) {
            TerminalHandler.invalidEntry();

        } else {
            Truck truck = this.getTruck(code);

            if (truck instanceof DumpTruck) {
                this.removeTruck(truck);
                TerminalHandler.println("<green>Camion benne supprimé avec succès.<reset>");
            } else {
                TerminalHandler.println("<yellow>Ce camion n'est pas un camion benne.<reset>");
            }
        }
    }


    public void showDumpTrucks() {
        for (Truck truck : trucks) {
            if (truck instanceof DumpTruck) {
                TerminalHandler.println(truck.toString());
            }
        }
    }



    // Initialising some values

    public void init() {
        RefrigeratedTruck refregiratedTruck1 = new RefrigeratedTruck(1, "Renault", "Truck", new Date(123, 11, 23), 8);
        DumpTruck dumpTruck1 = new DumpTruck(2, "Volvo", "Aero", new Date(118, 11, 10), 30);
        DumpTruck dumpTruck2 = new DumpTruck(3, "Mercedes", "eActros", new Date(116, 11, 5), 25);

        this.addTruck(refregiratedTruck1);
        this.addTruck(dumpTruck1);
        this.addTruck(dumpTruck2);
    }
}
