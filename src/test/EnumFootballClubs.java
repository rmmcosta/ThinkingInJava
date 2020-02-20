package test;

import java.util.Arrays;

enum FootballClubs {
    SLBENFICA, FCPORTO, SPORTINGCP
}

public class EnumFootballClubs {
    public static void main(String[] args) {
        System.out.println(Arrays.asList(FootballClubs.values()));
        FootballClubs myFootballClub = FootballClubs.SLBENFICA;
        System.out.println(String.format("What's my football club? %s", myFootballClub));
    }
}
