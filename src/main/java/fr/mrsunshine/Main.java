package fr.mrsunshine;


import fr.mrsunshine.hmi.TerminalHandler;
import fr.mrsunshine.hmi.InputReader;
import fr.mrsunshine.instances.TruckHandler;


public class Main {

    public static void startApplication() {

        TruckHandler truckHandler = TruckHandler.getInstance();
        truckHandler.init();

        TerminalHandler.println("Bienvenue sur le gestionnaire de camion.");

        while (true) {

            showMenu();
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


    private static void showMenu() {
        TerminalHandler.println("----------------------------------");
        TerminalHandler.println("<blue>1. <reset>Ajouter un camion frigorifique");
        TerminalHandler.println("<blue>2. <reset>Supprimer un camion frigorifique");
        TerminalHandler.println("<blue>3. <reset>Lister les camions frigorifique");

        TerminalHandler.println("<green>4. <reset>Ajouter un camion benne");
        TerminalHandler.println("<green>5. <reset>Supprimer un camion benne");
        TerminalHandler.println("<green>6. <reset>Lister les camions benne");

        TerminalHandler.println("<purple>7. <reset>Afficher tous les camions");
        TerminalHandler.println("<red>0. <reset>Quitter l'application");
        TerminalHandler.println("----------------------------------");
    }
}