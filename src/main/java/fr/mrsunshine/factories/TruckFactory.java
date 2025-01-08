package fr.mrsunshine.factories;

import fr.mrsunshine.instances.TruckHandler;
import fr.mrsunshine.objects.Truck;

import java.util.List;


public interface TruckFactory {
    /**
     * This function will create, using the CLI and user arguments, a trunk
     * @return Truck object
     */
    Truck createTruck();


    /**
     * This function remove a truck
     * @param truckHandler A TruckHandler object
     */
    void removeTruck(TruckHandler truckHandler);


    /**
     * @param trucks A list of Trucks
     */
    void showTrucks(List<Truck> trucks);
}
