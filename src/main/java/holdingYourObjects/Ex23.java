package holdingYourObjects;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

class Statistics{
    private static Map<Integer,Integer> numberDraw = new HashMap<Integer, Integer>();
    public static void drawNumbers(int count, int max) {
        Random r = new Random();
        for(int i=0;i<count;i++) {
            updateCount(r.nextInt(max));
        }
    }
    private static void updateCount(int num) {
        if(numberDraw.containsKey(num)) {
            Integer currCount = numberDraw.get(num);
            numberDraw.replace(num,currCount+1);
        } else {
            numberDraw.put(num,1);
        }
    }
    public static void printDraw() {
        System.out.println(numberDraw);
    }

    public static void printTop(int num) {
        //https://dzone.com/articles/how-to-sort-a-map-by-value-in-java-8
        Map<Integer,Integer> sortedMap = numberDraw
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .limit(num)
                .collect(
                        Collectors.toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1,e2)->e1,
                                LinkedHashMap::new
                        )
                );
        System.out.println(sortedMap);
    }
}

public class Ex23 {
    public static void main(String[] args) {
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
        Statistics.drawNumbers(10000,20);
        Statistics.printDraw();
        Statistics.printTop(10);
    }
}
