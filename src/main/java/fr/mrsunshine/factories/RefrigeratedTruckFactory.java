package fr.mrsunshine.factories;


import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.instances.TruckHandler;
import fr.mrsunshine.objects.RefrigeratedTruck;
import fr.mrsunshine.objects.Truck;

import java.util.Date;
import java.util.List;

public class RefrigeratedTruckFactory implements TruckFactory {


    @Override
    public Truck createTruck() {
        try {

            int code = InputReader.readInt("Entrez le code du camion:");
            String model = InputReader.readString("Entrez le modèle du camion:");
            String brand = InputReader.readString("Entrez la marque du camion:");
            Date registrationDate = InputReader.readDate("Entrez la date d'immatriculation (dd/MM/yyyy):");
            int holdTemperature = InputReader.readInt("Entrez la temperature de la soute:");

            if (model == null || brand == null || code == -1 || registrationDate == null || holdTemperature == -1) {
                throw new Exception("Invalid data detected");
            }

            return new RefrigeratedTruck(
                    code,
                    model,
                    brand,
                    registrationDate,
                    holdTemperature
            );

        } catch (Exception e) {
            TerminalHandler.invalidEntries();
        }

        return null;
    }


    @Override
    public void removeTruck(TruckHandler truckHandler) {
        int code = InputReader.readInt("Numéro du camion frigorifique à supprimer:");

        if (code == -1) {
            TerminalHandler.invalidEntry();

        } else {
            Truck truck = truckHandler.getTruck(code);

            if (truck instanceof RefrigeratedTruck) {
                truckHandler.removeTruck(truck);

            } else {
                TerminalHandler.println("<yellow>Ce camion n'est pas un camion frigorifique.<reset>");
            }
        }
    }


    @Override
    public void showTrucks(List<Truck> trucks) {
        for (Truck truck : trucks) {
            if (truck instanceof RefrigeratedTruck) {
                TerminalHandler.println(truck.toString());
            }
        }
    }
}
