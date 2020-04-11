package holdingYourObjects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex19 {
    public static void main(String[] args) {
        Set<String> hSet = new HashSet<String>();
        hSet.add("cenas");
        hSet.add("tal");
        hSet.add("ramon");
        hSet.add("ali");
        System.out.println(hSet);
        String[] keys = hSet.toArray(new String[0]);
        Arrays.sort(keys);
        Set<String> lSet = new LinkedHashSet<>();
        for (String s : keys) {
            lSet.add(s);
        }
        System.out.println(lSet);
        //or without using the for cycle
        //in this case we just pass the array as a list to the linked hashset constructor
        Set<String> sortedSet = new LinkedHashSet<>(Arrays.asList(keys));
        System.out.println(sortedSet);

        Set<String> randomSorted = new HashSet<>(Arrays.asList(keys));
        System.out.println("random sorted: " + randomSorted);
    }
}
