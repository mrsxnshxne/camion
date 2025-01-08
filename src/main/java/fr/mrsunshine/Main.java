package fr.mrsunshine;


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
        TerminalHandler.println("Bienvenue sur le gestionnaire de camion.");

        while (true) {

            TerminalHandler.showMenu();
            int inputResponse = InputReader.readInt("Votre sélection:");

            switch (inputResponse) {
                case 1:
                    truckHandler.addRefrigeratedTruck();
                    break;

                case 2:
                    truckHandler.removeRefrigeratedTruck();
                    break;

                case 3:
                    truckHandler.showRefrigeratedTrucks();
                    break;

                case 4:
                    truckHandler.addDumpTruck();
                    break;

                case 5:
                    truckHandler.removeDumpTruck();
                    break;

                case 6:
                    truckHandler.showDumpTrucks();
                    break;

                case 7:
                    truckHandler.showTrucks();
                    break;

                case 0:
                    System.exit(0);

                default:
                    TerminalHandler.invalidEntry();
            }
        }
    }
}