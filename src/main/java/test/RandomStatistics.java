package test;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class Counter implements Comparable<Counter> {
    private int i;
    private int key;

    public Counter(int key, int i) {
        this.key = key;
        this.i = i;
    }

    @Override
    public int compareTo(@NotNull Counter counter) {
        // use the > to order from the most frequent to the less frequent
        // or use the > to order on the other way around
        return this.i > counter.i ? -1 : (this.i == counter.i) ? 0 : 1;
    }

    @Override
    public String toString() {
        return Integer.toString(key) + "=" + Integer.toString(i);
    }
}

public class RandomStatistics {
    private static final int NUM_SAMPLES = 10000000;
    private static final int UPPER_LIMIT = 10;

    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> randoms = new HashMap<Integer, Integer>();
        for (int i = 0; i < NUM_SAMPLES; i++) {
            int key = random.nextInt(UPPER_LIMIT);
            if (randoms.containsKey(key)) {
                int newValue = randoms.get(key) + 1;
                randoms.replace(key, newValue);
            } else {
                randoms.put(key, 1);
            }
        }
        System.out.println(randoms);
        //not allowed
        //Collections.sort(randoms);

        //in order to be able to sort the hashmap
        //we can use a custom class instead of integer that implements comparable
        //that class will hold both the key and the frequency
        List<Counter> counters = new ArrayList<Counter>();
        Set entrySet = randoms.entrySet();
        System.out.println(entrySet);
        Iterator randomsIterator = entrySet.iterator();
        while (randomsIterator.hasNext()) {
            Object currObject = randomsIterator.next();
            Map.Entry<Integer, Integer> currEntry = (Map.Entry<Integer, Integer>) currObject;
            counters.add(new Counter(currEntry.getKey(), currEntry.getValue()));
        }
        System.out.println(counters);
        Collections.sort(counters);
        System.out.println(counters);
    }
}
