package holdingYourObjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapRandom {
    private Map<Integer, Integer> rMap = new HashMap<Integer, Integer>();
    public void countRandoms(Integer num){
        if(rMap.containsKey(num)) {
           Integer tempOldValue = rMap.get(num);
           rMap.replace(num,tempOldValue+1);
        } else {
            rMap.put(num,1);
        }
    }
    public void printMap(){
        System.out.println(rMap);
    }
    public static void main(String[] args) {
        Random r = new Random();
        MapRandom mr = new MapRandom();

        for(int i=0;i<10000;i++) {
            mr.countRandoms(r.nextInt(10));
        }

        mr.printMap();
    }
}
