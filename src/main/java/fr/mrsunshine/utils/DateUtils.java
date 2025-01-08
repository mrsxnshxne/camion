package fr.mrsunshine.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static Date createDateObject(int day, int month, int year) {
        return new Date(year-1900, month-1, day);
    }

    public static String formatDateObject(Date date) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
