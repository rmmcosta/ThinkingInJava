package holdingYourObjects;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.Math.round;

public class Ex14 {
    public static void main(String[] args) {
        LinkedList<Integer> ints = new LinkedList<Integer>();
        System.out.println("gives a number:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=1;i<=num;i++){
            ListIterator<Integer> li = ints.listIterator((int) Math.ceil((double)ints.size()/2));
            li.add(i);
        }
        System.out.println(ints);
    }
}
