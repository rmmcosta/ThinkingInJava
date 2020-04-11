package test;

import java.util.Random;

enum Clubs {
    BENFICA, FCPORTO, SCP
}

public class Champion {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(Clubs.values()[r.nextInt(2)]);
    }
}
