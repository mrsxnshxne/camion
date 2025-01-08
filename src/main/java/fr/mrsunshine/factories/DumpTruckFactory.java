package fr.mrsunshine.factories;


import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.instances.TruckHandler;
import fr.mrsunshine.objects.DumpTruck;
import fr.mrsunshine.objects.Truck;
import fr.mrsunshine.utils.DateUtils;

import java.util.List;

public class DumpTruckFactory implements TruckFactory {


    @Override
    public Truck createTruck() {
        try {

            int code = InputReader.readInt("Entrez le code du camion:");
            String model = InputReader.readString("Entrez le modèle du camion:");
            String brand = InputReader.readString("Entrez la marque du camion:");
            int registration_day = InputReader.readInt("Entrez le jour d'immatriculation:");
            int registration_month = InputReader.readInt("Entrez le mois d'immatriculation:");
            int registration_year = InputReader.readInt("Entrez l'année d'immatriculation:");
            int holdSize = InputReader.readInt("Entrez le volume de la benne:");

            if (model == null || brand == null || code == -1 || registration_day == -1 || registration_month == -1 || registration_year == -1 || holdSize == -1) {
                throw new Exception("Invalid data detected");
            }

            return new DumpTruck(
                    code, model,
                    brand,
                    DateUtils.createDateObject(registration_day, registration_month, registration_year),
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
