package fr.mrsunshine.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DateUtils {


    public static Date createDateObject(int day, int month, int year) {
        return new Date(year-1900, month-1, day);
    }

    public static String formatDateObject(Date date) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }


    /**
     * Convert a string date in a Date object
     * @param date Must be a String date with the format "dd/MM/yyyy", "dd-MM-yyyy" or "dd.MM.yyyy"
     * @return A Date object
     */
    public static Date createDateObject(String date) {
        try {

            // Regex found here:
            // https://stackoverflow.com/questions/15491894/regex-to-validate-date-formats-dd-mm-yyyy-dd-mm-yyyy-dd-mm-yyyy-dd-mmm-yyyy

            if (!date.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                return null;
            }

            List<String> split = List.of(date.split("/"));
            if (split.size() != 3) return null;

            return createDateObject(
                    Integer.parseInt(split.get(0)),
                    Integer.parseInt(split.get(1)),
                    Integer.parseInt(split.get(2))
            );
        } catch (Exception e) {
            return null;
        }
    }
}
