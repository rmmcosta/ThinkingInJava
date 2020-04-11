package holdingYourObjects;

import java.lang.reflect.Array;
import java.util.*;

public class Ex12 {
    static void fillList(List<Integer> list,int length) {
        Random r = new Random();
        for(int i=0;i<length;i++) {
            list.add(r.nextInt(20));
        }
    }
    static void reverse(List<Integer> l1){
        ListIterator<Integer> lifwd = l1.listIterator();
        ListIterator<Integer> lirev = l1.listIterator(l1.size());
        int middle = l1.size()>>1;//the same as divide by 2
        for(int i=0;i<middle;i++) {
            int temp = lifwd.next();
            lifwd.set(lirev.previous());
            lirev.set(temp);
            System.out.println(l1);
        }
    }
    public static void main(String[] args) {
        final int NUMELEM = 5;
        List<Integer> l1 = new ArrayList<Integer>();
        fillList(l1,NUMELEM);
        List<Integer> l2 = new ArrayList<Integer>();
        fillList(l2,NUMELEM);
        int i=1;
        ListIterator<Integer> li = l2.listIterator(NUMELEM-1);
        System.out.println(l1);
        System.out.println(l2);
        l1.set(0,l2.get(NUMELEM-1));
        while(li.hasPrevious()) {
            l1.set(i++,li.previous());
        }
        System.out.println(l1);
        System.out.println(l2);
        Collections.reverse(l1);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println("--------------");

        List<Integer> l3 = new ArrayList<Integer>();
        fillList(l3,NUMELEM);
        System.out.println(l3);
        List<Integer> l4 = new ArrayList<Integer>();
        ListIterator<Integer> li1 = l3.listIterator(NUMELEM-1);
        l4.add(l3.get(NUMELEM-1));
        while(li1.hasPrevious()){
            l4.add(li1.previous());
        }
        System.out.println(l4);

        System.out.println("-------------");
        List<Integer> l5 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> l6 = new ArrayList<Integer>(l5);
        System.out.println(l5);
        System.out.println(l6);
        reverse(l6);
        System.out.println(l5);
        System.out.println(l6);
    }
}
