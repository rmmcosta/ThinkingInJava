package ControllingExecution;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void markNotPrimes(boolean[] numbers, int p, int max){
        for(int i = 2*p;i<max;i+=p){
            numbers[i] = true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();

        boolean[] numbers = new boolean[max];
        for(int i = 2;i<max;i++) {
            if(!numbers[i])
                markNotPrimes(numbers,i,max);
        }

        for(int i=2;i<max;i++){
            if(!numbers[i])
                System.out.println(i);
        }
    }
}
