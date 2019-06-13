package timeUtilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getCurrTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    public static void printCurrTimestamp() {
        System.out.println(getCurrTimestamp());
    }
}
