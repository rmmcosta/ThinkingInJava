package ControllingExecution;

import java.util.Random;

public class Ex2 {
    public static void main(String[] args) {
        Random r = new Random();
        int x,y;
        for(int i = 0;i < 25;i++) {
            compareRandom(r);
        }
    }

    public static void compareRandom(Random r) {
        int x;
        int y;
        x = r.nextInt(10);
        y = r.nextInt(10);
        System.out.println(y + " greater than " + x + "->" + (y>x));
        System.out.println(y + " less than " + x + "->" + (y<x));
        System.out.println(y + " equal to " + x + "->" + (y==x));
        System.out.println("-------------");
    }
}
