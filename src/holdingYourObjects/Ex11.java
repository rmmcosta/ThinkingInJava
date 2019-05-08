package holdingYourObjects;

import javafx.collections.transformation.SortedList;

import java.util.*;

public class Ex11 {
    static void printCollection(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }

    static void printMap(Map m) {
        System.out.println(m);
    }

    static void printMap2(Map m) {
        m.forEach((key, value) -> {
            System.out.println("key:" + key + ", value:" + value);
        });
    }

    static void printMap3(HashMap<Integer, Integer> h) {
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }

    static HashMap<Integer, Integer> getHashMaps(int i) {
        Random r = new Random();
        HashMap<Integer, Integer> tempHashMap = new HashMap<Integer, Integer>();
        for (int j = 0; j < i; j++) {
            tempHashMap.put(r.nextInt(100), r.nextInt(50));
        }
        return tempHashMap;
    }

    public static void main(String[] args) {
        List<Integer> lints = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 10));
        printCollection(lints);
        List<String> lstrings = new LinkedList<String>(Arrays.asList("1", "5", "2", "10"));
        printCollection(lstrings);

        Set<Integer> sints = new HashSet<Integer>(Arrays.asList(1, 5, 2, 10));
        printCollection(sints);
        Set<String> sstrings = new TreeSet<String>(Arrays.asList("1", "5", "2", "10"));
        printCollection(sstrings);
        Set<Float> sfloats = new LinkedHashSet<Float>(Arrays.asList(1.0f,5.0f,2.0f,10.0f));
        printCollection(sfloats);

        Map<Integer, Integer> mints = new HashMap<Integer, Integer>(getHashMaps(4));
        printMap(mints);
        printMap2(mints);
        printMap3((HashMap<Integer, Integer>) mints);
        Map<Integer, Integer> treemaps = new TreeMap<Integer, Integer>(getHashMaps(4));
        printMap(treemaps);
        Map<Integer, Integer> linkedmaps = new LinkedHashMap<>(getHashMaps(4));
        printMap(linkedmaps);
    }
}
