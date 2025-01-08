package fr.mrsunshine.hmi;


public class TerminalHandler {

    /**
     * Replacing tags by the console color code
     */
    public static String parse(String entry) {
        return entry
                .replaceAll("<reset>", "\u001B[0m")
                .replaceAll("<black>", "\u001B[30m")
                .replaceAll("<red>", "\u001B[31m")
                .replaceAll("<green>", "\u001B[32m")
                .replaceAll("<yellow>", "\u001B[33m")
                .replaceAll("<blue>", "\u001B[34m")
                .replaceAll("<purple>", "\u001B[35m")
                .replaceAll("<cyan>", "\u001B[36m")
                .replaceAll("<white>", "\u001B[37m");
    }

    /**
     * The classic println but with color parsing
     */
    public static void println(String entry) {
        System.out.println(parse(entry));
    }

    /**
     * Show an invalid entry message
     */
    public static void invalidEntry() {
        println("<yellow>Entrée invalide. Veuillez vérifier la syntaxe puis réessayer.<reset>");
    }

    /**
     * Show an invalid entries message
     */
    public static void invalidEntries() {
        println("<yellow>Une ou plusieurs entrées sont invalides. Veuillez vérifier la syntaxe puis réessayer.<reset>");
    }

    /**
     * Show the main menu of the application
     */
    public static void showMenu() {
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
