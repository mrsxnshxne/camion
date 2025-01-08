package fr.mrsunshine.hmi;


public class TerminalHandler {

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

    public static void println(String entry) {
        System.out.println(parse(entry));
    }

    public static void invalidEntry() {
        println("<yellow>Entrée invalide. Veuillez vérifier la syntaxe puis réessayer.<reset>");
    }

    public static void invalidEntries() {
        println("<yellow>Une ou plusieurs entrées sont invalides. Veuillez vérifier la syntaxe puis réessayer.<reset>");
    }
}
