package operators;

import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {

        char getC;
        Scanner sc = new Scanner(System.in);

        while(true){
            getC = sc.next().charAt(0);
            System.out.println(getC);
            System.out.println(Integer.toBinaryString(getC));
        }
    }
}
