package fr.mrsunshine.hmi;

import java.util.Scanner;


public class InputReader {

    private static Scanner read(String text) {
        TerminalHandler.println(text);
        return new Scanner(System.in);
    }

    public static String readString(String text) {
        return read(text).nextLine();
    }

    public static int readInt(String text) {
        try {
            return read(text).nextInt();
        } catch (Exception e) {
            return -1;
        }
    }
}
