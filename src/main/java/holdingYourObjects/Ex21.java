package holdingYourObjects;

import java.io.IOException;
import java.util.*;

public class Ex21 {
    private static Map<String,Integer> mapWords = new HashMap<String,Integer>();
    private static void printWordsOcurrence(Map m) {
        List<String> words = new ArrayList<String>(m.keySet());
        //Collections.sort(words);
        Collections.sort(words,String.CASE_INSENSITIVE_ORDER);
        // need to use the iterator to keep the order
        //if we, for instance, use the for cycle the words will not be sorted
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String currWord = it.next();
            System.out.print(currWord + ": " + mapWords.get(currWord));
            System.out.println();
        }
    }
    private static void updateWordsOcurrence(String word) {
        if(mapWords.containsKey(word)) {
            int currCount = mapWords.get(word);
            mapWords.replace(word,currCount+1);
        } else {
            mapWords.put(word,1);
        }
    }
    public static void main(String[] args) {
        String fPath = "C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt";
        try {
            List<String> words = TextFile.getWords(fPath, "[^a-zA-Z_0-9]");
            for(String s:words) {
                updateWordsOcurrence(s);
            }
            printWordsOcurrence(mapWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
