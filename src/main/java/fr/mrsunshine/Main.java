package fr.mrsunshine;


import fr.mrsunshine.factories.DumpTruckFactory;
import fr.mrsunshine.factories.RefrigeratedTruckFactory;
import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.instances.TruckHandler;


public class Main {

    public static void main(String[] args) {
        Main.startApplication();
    }


    public static void startApplication() {

        TruckHandler truckHandler = TruckHandler.getInstance();
        truckHandler.initData();

        RefrigeratedTruckFactory refrigeratedTruckFactory = new RefrigeratedTruckFactory();
        DumpTruckFactory dumpTruckFactory = new DumpTruckFactory();

        TerminalHandler.println("Bienvenue sur le gestionnaire de camion.");

        while (true) {

            TerminalHandler.showMenu();
            int inputResponse = InputReader.readInt("Votre sélection:");

            switch (inputResponse) {

                // Refrigerated
                case 1:
                    truckHandler.addTruck(refrigeratedTruckFactory);
                    break;
                case 2:
                    truckHandler.removeTruck(refrigeratedTruckFactory);
                    break;
                case 3:
                    truckHandler.showTrucks(refrigeratedTruckFactory);
                    break;

                // Dump
                case 4:
                    truckHandler.addTruck(dumpTruckFactory);
                    break;
                case 5:
                    truckHandler.removeTruck(dumpTruckFactory);
                    break;
                case 6:
                    truckHandler.showTrucks(dumpTruckFactory);
                    break;

                // All
                case 7:
                    truckHandler.showTrucks(null);
                    break;

                // Application
                case 0:
                    System.exit(0);
                default:
                    TerminalHandler.invalidEntry();
            }
        }
    }
}