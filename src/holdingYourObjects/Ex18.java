package holdingYourObjects;

import java.util.*;

public class Ex18 {
    public static void main(String[] args) {
        Map<String,Integer> hmap = new HashMap<String,Integer>();
        hmap.put("cenas",1);
        hmap.put("tal",2);
        hmap.put("ali",0);
        hmap.put("ramon",5);
        System.out.println(hmap);
        Map<String,Integer> lmap = new LinkedHashMap<>();
        Map<String,Integer> tmap = new TreeMap<>(hmap);
        System.out.println(tmap);
        Iterator it = tmap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String,Integer> currEntry = (Map.Entry<String, Integer>) it.next();
            lmap.put(currEntry.getKey(),currEntry.getValue());
        }
        System.out.println(lmap);

        String[] keys = hmap.keySet().toArray(new String[0]);
        //System.out.println(keys);
        Arrays.sort(keys);
        //System.out.println(keys);
        Map<String,Integer> lmap2 = new LinkedHashMap<>();
        for(String s:keys) {
            lmap2.put(s,hmap.get(s));
        }
        System.out.println(lmap2);
    }
}
