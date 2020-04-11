package test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println(calcMean());
    }

    static double calcMean() {
        System.out.println("Please input some integers and a letter when you want to end inputting integers:");
        Scanner sc = new Scanner(System.in);
        int accum = 0, count = 0;
        while (sc.hasNextInt()) {
            accum += sc.nextInt();
            count++;
        }
        return (double)accum/(double)count;
    }
}
