package fr.mrsunshine.factories;

import fr.mrsunshine.instances.TruckHandler;
import fr.mrsunshine.objects.Truck;

import java.util.List;


public interface TruckFactory {
    Truck createTruck();
    void removeTruck(TruckHandler truckHandler);
    void showTrucks(List<Truck> trucks);
}
