package holdingYourObjects;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static holdingYourObjects.MyEntry.getSortedMap;
import static holdingYourObjects.MyEntry.getSortedMap_v2;

public class Ex24 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Name", "Ricardo");
        linkedHashMap.put("Surname", "Costa");
        linkedHashMap.put("Hobby", "Software Development");
        linkedHashMap.put("Girlfriend", "Ana");
        linkedHashMap.put("Ana", "Girlfriend");
        linkedHashMap.put("Zoo Lisboa", "Never went");
        System.out.println(linkedHashMap);
        System.out.println(getSortedMap(linkedHashMap));
        System.out.println(getSortedMap_v2(linkedHashMap));
    }
}

class MyEntry implements Comparable<MyEntry> {
    public String key;
    public String value;

    public MyEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(@NotNull MyEntry myEntry) {
        return this.key.compareToIgnoreCase(myEntry.key);
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

    public static LinkedHashMap<String, String> getSortedMap(LinkedHashMap<String, String> originalMap) {
        Set<Map.Entry<String, String>> thePairs = originalMap.entrySet();
        System.out.println("The set: " + thePairs);
        List<MyEntry> theList = new ArrayList<MyEntry>();
        Iterator<Map.Entry<String, String>> iterator = thePairs.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> currEntry = iterator.next();
            theList.add(new MyEntry(currEntry.getKey(), currEntry.getValue()));
        }
        System.out.println("Unsorted list: " + theList);
        Collections.sort(theList);
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (MyEntry myEntry : theList) {
            sortedMap.put(myEntry.key, myEntry.value);
        }
        return sortedMap;
    }

    public static LinkedHashMap<String, String> getSortedMap_v2(LinkedHashMap<String, String> originalMap) {
        String[] keys = originalMap.keySet().toArray(new String[0]);
        /*List<String> listKeys = new ArrayList<String>(Arrays.asList(keys));
        Collections.sort(listKeys);*/
        //we also have an Arrays.sort that we can use
        Arrays.sort(keys);
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (String key : keys) {
            sortedMap.put(key, originalMap.get(key));
        }
        return sortedMap;
    }
}