package holdingYourObjects;

import java.util.*;

import static operators.Utils.print;

public class Ex6 {

    public static ArrayList<String> arrayList(int num) {
        ArrayList<String> temp = new ArrayList<String>();
        String[] rStrings = {"the5", "the4", "the9"};
        Random r = new Random();
        for(int i =0;i<num;i++) {
            temp.add(rStrings[r.nextInt(rStrings.length)]);
        }
        return temp;
    }
    
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<String> Strings = arrayList(7);
        print("1: " + Strings);
        String h = "23";
        Strings.add(h); // Automatically resizes
        print("2: " + Strings);
        print("3: " + Strings.contains(h));
        Strings.remove(String.valueOf(h)); // Remove by object
        print("3.5: " + Strings.contains(String.valueOf(h)));
        String p = Strings.get(2);
        print("4: " + p + " " + Strings.indexOf(p));
        String theS = "5";
        print("5: " + Strings.indexOf(theS));
        print("6: " + Strings.remove(theS));
// Must be the exact object:
        print("7: " + Strings.remove(p));
        print("8: " + Strings);
        Strings.add(3, "5"); // Insert at an index
        print("9: " + Strings);
        List<String> sub = Strings.subList(1, 4);
        print("subList: " + sub);
        print("10: " + Strings.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
// Order is not important in containsAll():
        print("11: " + Strings.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + Strings.containsAll(sub));
        List<String> copy = new ArrayList<String>(Strings);
        sub = Arrays.asList(Strings.get(1), Strings.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<String>(Strings); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        print("15: " + copy);

        if(copy.size()>1)
            copy.set(1, "55"); // Replace an element

        print("16: " + copy);

        if(copy.size()>2)
            copy.addAll(2, sub); // Insert a list in the middle

        print("17: " + copy);
        print("18: " + Strings.isEmpty());
        Strings.clear(); // Remove all elements
        print("19: " + Strings);
        print("20: " + Strings.isEmpty());
        Strings.addAll(arrayList(4));
        print("21: " + Strings);
        Object[] o = Strings.toArray();
        print("22: " + o[3]);
        String[] pa = Strings.toArray(new String[0]);
        print("23: " + pa[3]);
    }
}
