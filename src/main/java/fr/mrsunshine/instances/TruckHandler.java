package fr.mrsunshine.instances;

import fr.mrsunshine.factories.TruckFactory;
import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.objects.DumpTruck;
import fr.mrsunshine.objects.RefrigeratedTruck;
import fr.mrsunshine.objects.Truck;

import java.util.*;

public class TruckHandler {

    private static final TruckHandler instance = new TruckHandler();


    private List<Truck> trucks = new ArrayList<>();


    public TruckHandler() { }


    // Instance

    public static TruckHandler getInstance() {
        return instance;
    }


    // Trucks

    /**
     * Get all trucks
     * @return List
     */
    public List<Truck> getTrucks() {
        return trucks;
    }

    /**
     * Get all trucks sorted by their code
     * @return List
     */
    public List<Truck> getSortedTrucks() {
        trucks.sort(Comparator.comparingInt(Truck::getCode));
        return trucks;
    }

    /**
     * Set trucks in the list of trucks
     * @param trucks List of trucks
     */
    public void setTrucks(List<Truck> trucks) {
        this.trucks = trucks;
    }

    // Truck

    /**
     * Get a specific truck using his code
     * @param code Code of the truck
     * @return Truck or null
     */
    public Truck getTruck(int code) {
        for (Truck truck : trucks) {
            if (truck.getCode() == code) {
                return truck;
            }
        }
        return null;
    }


    /**
     * Add a truck in the truck list
     * @param truck Truck
     */
    public void addTruck(Truck truck) {
        if (truck == null) {
            TerminalHandler.println("<yellow>Erreur, le camion n'a pas été ajouté.<reset>");
            return;
        }
        this.trucks.add(truck);
        TerminalHandler.println("<green>Camion ajouté avec succès.<reset>");
    }


    /**
     * Remove a truck in the truck list
     * @param truck Truck
     */
    public void removeTruck(Truck truck) {
        if (truck == null) return;
        this.trucks.remove(truck);
        TerminalHandler.println("<green>Camion supprimé avec succès.<reset>");
    }


    // Factory

    /**
     * Ask the user for all information needed and if something is wrong/miss-spelled, the code send a message to prevent the user.
     * Else, the truck is added to the truck list.
     */
    public void addTruck(TruckFactory truckFactory) {
        Truck truck = truckFactory.createTruck();

        if (truck != null) {
            if (this.getTruck(truck.getCode()) != null) {
                TerminalHandler.println("<yellow>Un camion avec ce code existe déjà.<reset>");
            } else {
                this.addTruck(truck);
            }
        }
    }


    /**
     * Ask the user for the code of the truck to remove.
     * If the code is invalid or is owned by a non-specific truck, an invalid syntax message is sent.
     * Else, the truck is removed.
     */
    public void removeTruck(TruckFactory truckFactory) {
        truckFactory.removeTruck(this);
    }


    /**
     * Show all trucks in the truck list (and sorted by their code)
     * If a factory is provided, we use the factory showTrunks function
     */
    public void showTrucks(TruckFactory truckFactory) {
        if (truckFactory == null) {
            for (Truck truck : this.getSortedTrucks()) {
                TerminalHandler.println(truck.toString());
            }
        } else {
            truckFactory.showTrucks(this.getSortedTrucks());
        }
    }


    /**
     * Just for initialising some data (for test)
     */
    public void initData() {
        RefrigeratedTruck refrigerateTruck1 = new RefrigeratedTruck(1, "Truck", "Renault", new Date(123, 11, 23), 8);
        DumpTruck dumpTruck1 = new DumpTruck(23, "Aero", "Volvo", new Date(118, 11, 10), 30);
        DumpTruck dumpTruck2 = new DumpTruck(3, "eActros", "Mercedes", new Date(116, 11, 5), 25);

        this.addTruck(refrigerateTruck1);
        this.addTruck(dumpTruck1);
        this.addTruck(dumpTruck2);
    }
}
