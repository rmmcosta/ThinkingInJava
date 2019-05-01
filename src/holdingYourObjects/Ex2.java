package holdingYourObjects;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();
        /*nums.add(5);
        for (Integer i:nums
             ) {
            System.out.println(i);
        }
        nums.add(15);
        for (Integer i:nums
        ) {
            System.out.println(i);
        }
        ((ArrayList<Integer>) nums).set(0,6);

        for (Integer i:nums
        ) {
            System.out.println(i);
        }*/
        //Collection<Integer> c = new HashSet<Integer>();
        Set c = new HashSet<Integer>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        /*for(Integer i : c)
            System.out.print(i + ", ");
        */
        Iterator iter = c.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < 10; i++)
            set.add(i*10); // Autoboxing
        for(Integer i:set)
            System.out.println(i);
        set.forEach(System.out::println); //only works in java 8
        System.out.println("size:"+set.size());
        set.add(0);
        System.out.println("size:"+set.size());
        //sets do not allow duplicates
    }
}
