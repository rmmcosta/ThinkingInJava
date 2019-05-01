package holdingYourObjects;

import java.util.*;
import static operators.Utils.print;

public class Ex5 {

    public static ArrayList<Integer> arrayList(int num) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Integer[] rIntegers = {5, 4, 9};
        Random r = new Random();
        for(int i =0;i<num;i++) {
            temp.add(rIntegers[r.nextInt(rIntegers.length)]);
        }
        return temp;
    }
    
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> Integers = arrayList(7);
        print("1: " + Integers);
        Integer h = 23;
        Integers.add(h); // Automatically resizes
        print("2: " + Integers);
        print("3: " + Integers.contains(h));
        Integers.remove(Integer.valueOf(h)); // Remove by object
        print("3.5: " + Integers.contains(Integer.valueOf(h)));
        Integer p = Integers.get(2);
        print("4: " + p + " " + Integers.indexOf(p));
        Integer Integer = 5;
        print("5: " + Integers.indexOf(Integer));
        print("6: " + Integers.remove(Integer));
// Must be the exact object:
        print("7: " + Integers.remove(p));
        print("8: " + Integers);
        Integers.add(3, 5); // Insert at an index
        print("9: " + Integers);
        List<Integer> sub = Integers.subList(1, 4);
        print("subList: " + sub);
        print("10: " + Integers.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
// Order is not important in containsAll():
        print("11: " + Integers.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + Integers.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(Integers);
        sub = Arrays.asList(Integers.get(1), Integers.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<Integer>(Integers); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        print("15: " + copy);

        if(copy.size()>1)
            copy.set(1, 5); // Replace an element

        print("16: " + copy);

        if(copy.size()>2)
            copy.addAll(2, sub); // Insert a list in the middle

        print("17: " + copy);
        print("18: " + Integers.isEmpty());
        Integers.clear(); // Remove all elements
        print("19: " + Integers);
        print("20: " + Integers.isEmpty());
        Integers.addAll(arrayList(4));
        print("21: " + Integers);
        Object[] o = Integers.toArray();
        print("22: " + o[3]);
        Integer[] pa = Integers.toArray(new Integer[0]);
        print("23: " + pa[3]);
    }
}
