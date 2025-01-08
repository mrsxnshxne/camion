package fr.mrsunshine.hmi;

import java.util.Scanner;


public class InputReader {

    /**
     * @param text The text containing the question to answer
     * @return Scanner
     */
    private static Scanner read(String text) {
        TerminalHandler.println(text);
        return new Scanner(System.in);
    }


    /**
     * @param text The text containing the question to answer
     * @return String
     */
    public static String readString(String text) {
        return read(text).nextLine();
    }


    /**
     * @param text The text containing the question to answer
     * @return Integer
     */
    public static int readInt(String text) {
        try {
            return read(text).nextInt();
        } catch (Exception e) {
            return -1;
        }
    }
}
