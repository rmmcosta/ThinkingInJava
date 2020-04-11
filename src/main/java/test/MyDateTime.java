package test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyDateTime {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void printCurrDateTime() {
        System.out.println(getCurrDateTime());
    }

    public static String getCurrDateTime() {
        LocalDateTime today = LocalDateTime.now();
        return formatter.format(today);
    }

    public static String toDateTime(long currentTimeMillis) {
        return String.valueOf(new Date(currentTimeMillis));
    }
}
