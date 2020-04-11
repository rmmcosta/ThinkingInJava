package ControllingExecution;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex9_Fibonacci {
    private static void fibo(int max){
        int curr=0;
        int curr1 = 1;
        int temp;
        do{
            temp = curr1+curr;
            System.out.print(curr1);
            System.out.print(' ');
            curr=curr1;
            curr1=temp;
        }while(curr1<=max);
        System.out.println();
    }

    private static void printFibo(int max){
        for(int i = 1;i<=max;i++){
            System.out.print("fibo(" + i + "):" + nextFibo(i));
            System.out.print(' ');
        }
        System.out.println();
    }
    private static long nextFibo(int value){
        if(value<=2)
            return 1;
        return nextFibo(value-1) + nextFibo(value-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        while(true){
            value = sc.nextInt();
            System.out.println(LocalDateTime.now());
            fibo(value);
            System.out.println(LocalDateTime.now());
            System.out.println(LocalDateTime.now());
            printFibo(value);
            System.out.println(LocalDateTime.now());
        }
    }
}
