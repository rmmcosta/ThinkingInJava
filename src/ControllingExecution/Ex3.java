package ControllingExecution;

import java.util.Random;
import static ControllingExecution.Ex2.compareRandom;

public class Ex3 {
    public static void main(String[] args) {
        Random r = new Random();
        while(true){
            compareRandom(r);
        }
    }
}
