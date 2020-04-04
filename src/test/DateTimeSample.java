package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeSample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        System.out.println(now.format(dateTimeFormatter));
    }
}
