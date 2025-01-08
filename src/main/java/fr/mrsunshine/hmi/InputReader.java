package fr.mrsunshine.hmi;

import fr.mrsunshine.utils.DateUtils;

import java.util.Date;
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


    /**
     * Ask for a Date usign the following formats: "dd/MM/yyyy", "dd-MM-yyyy" or "dd.MM.yyyy"
     * @param text The text containing the question to answer
     * @return A Date object
     */
    public static Date readDate(String text) {
        try {
            String entry = read(text).next();
            return DateUtils.createDateObject(entry);

        } catch (Exception e) {
            return null;
        }
    }
}
