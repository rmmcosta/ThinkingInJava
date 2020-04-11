package ControllingExecution;

import java.util.Scanner;

public class Ex4 {
    public static void checkPrime(Scanner sc){
        int x = sc.nextInt();
        for(int i = 2;i<x;i+=2){
            if(x%i==0) {
                System.out.println("Not a Prime");
                checkPrime(sc);
            }
            for(int j = 3;j<x;j+=2) {
                if(x%j==0) {
                    System.out.println("Not a Prime");
                    checkPrime(sc);
                }
            }
            System.out.println("Prime");
            checkPrime(sc);
        }
        System.out.println("Prime");
        checkPrime(sc);
    }

    public static void printPrimes(int max){
        for(int i = 1;i<max;i++){
            boolean isPrime = true;
            for(int j = 2;j<i;j++){
                if(i%j==0){
                    isPrime = false;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Please input an int number.");
        Scanner sc = new Scanner(System.in);
        //checkPrime(sc);
        printPrimes(sc.nextInt());
    }
}
