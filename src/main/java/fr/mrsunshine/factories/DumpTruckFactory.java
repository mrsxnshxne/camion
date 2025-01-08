package fr.mrsunshine.factories;


import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.instances.TruckHandler;
import fr.mrsunshine.objects.DumpTruck;
import fr.mrsunshine.objects.Truck;

import java.util.Date;
import java.util.List;

public class DumpTruckFactory implements TruckFactory {


    @Override
    public Truck createTruck() {
        try {

            int code = InputReader.readInt("Entrez le code du camion:");
            String model = InputReader.readString("Entrez le modèle du camion:");
            String brand = InputReader.readString("Entrez la marque du camion:");
            Date registration_date = InputReader.readDate("Entrez la date d'immatriculation (dd/MM/yyyy):");
            int holdSize = InputReader.readInt("Entrez le volume de la benne:");

            if (model == null || brand == null || code == -1 || registration_date == null || holdSize == -1) {
                throw new Exception("Invalid data detected");
            }

            return new DumpTruck(
                    code,
                    model,
                    brand,
                    registration_date,
                    holdSize
            );

        } catch (Exception e) {
            TerminalHandler.invalidEntries();
        }

        return null;
    }


    @Override
    public void removeTruck(TruckHandler truckHandler) {
        int code = InputReader.readInt("Numéro du camion benne à supprimer:");

        if (code == -1) {
            TerminalHandler.invalidEntry();

        } else {
            Truck truck = truckHandler.getTruck(code);

            if (truck instanceof DumpTruck) {
                truckHandler.removeTruck(truck);

            } else {
                TerminalHandler.println("<yellow>Ce camion n'est pas un camion benne.<reset>");
            }
        }
    }


    @Override
    public void showTrucks(List<Truck> trucks) {
        for (Truck truck : trucks) {
            if (truck instanceof DumpTruck) {
                TerminalHandler.println(truck.toString());
            }
        }
    }
}
