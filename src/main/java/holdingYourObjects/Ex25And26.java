package holdingYourObjects;

import test.FileWordsParser;

import java.lang.reflect.Array;
import java.util.*;

import static holdingYourObjects.CountWords.*;

public class Ex25And26 {
    public static void main(String[] args) {
        String filePath = "/home/ricardo/IdeaProjects/Github/ThinkingInJava/TextDocument.txt";
        Map<String, ArrayList<Integer>> wordsCount = fillMap(filePath);
        System.out.println(wordsCount);
        String originalText = recreateOriginalText(wordsCount);
        System.out.println(originalText);
        /*Set<Map.Entry<String, ArrayList<Integer>>> entries = new HashSet<>();
        entries.add(Map.entry("Cenas", new ArrayList<>(Arrays.asList(21))));
        System.out.println(entries);*/
        System.out.println(recreateOriginalText_v2(wordsCount));
    }
}

class CountWords {
    public static Map<String, ArrayList<Integer>> fillMap(String filePath) {
        Map<String, ArrayList<Integer>> wordsCount = new HashMap<>();
        FileWordsParser fileWordsParser = new FileWordsParser(filePath);
        List<String> words = fileWordsParser.wordsParse();
        for (int i = 0; i < words.size(); i++) {
            String key = words.get(i);
            if (wordsCount.containsKey(key)) {
                ArrayList<Integer> currCounts = wordsCount.get(key);
                currCounts.add(i);
                wordsCount.put(key, currCounts);
            } else {
                wordsCount.put(key, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return wordsCount;
    }

    public static String recreateOriginalText(Map<String, ArrayList<Integer>> map) {
        Set<Map.Entry<String, ArrayList<Integer>>> entries = map.entrySet();
        //calculate numberof words
        Iterator<Map.Entry<String, ArrayList<Integer>>> iterator = entries.iterator();
        int totalNumWords = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Integer>> currEntry = iterator.next();
            totalNumWords += currEntry.getValue().size();
        }
        String text = "";
        int count = 0;
        while (count < totalNumWords) {
            iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, ArrayList<Integer>> entry = iterator.next();
                ArrayList<Integer> currCount = entry.getValue();
                if (currCount.contains(count)) {
                    text += text == "" ? entry.getKey() : " " + entry.getKey();
                    count++;
                }
            }
        }
        return text;
    }

    public static String recreateOriginalText_v2(Map<String, ArrayList<Integer>> map) {
        //the treemap will automatic order by key
        TreeMap<Integer, String> originalWords = new TreeMap<>();
        //we need to iterate through every word and for each word
        //through every count
        Iterator<Map.Entry<String, ArrayList<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<Integer>> currEntry = iterator.next();
            for (Integer i : currEntry.getValue()) {
                originalWords.put(i, currEntry.getKey());
            }
        }
        String[] words = originalWords.values().toArray(new String[0]);
        return String.join(" ", words);
    }
}

