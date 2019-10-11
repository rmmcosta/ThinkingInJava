package holdingYourObjects;

import java.io.IOException;
import java.util.*;

import static stringUtilities.StringUtil.convertStringToCharList;
import static timeUtilities.Time.printCurrTimestamp;


public class Ex16 {
    private static Map<Character, Integer> vowelsQty = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
        // Create a Set of the vowels.
        System.out.println("Begin");
        printCurrTimestamp();
        int totalVowels = getTotalVowels("C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt");

        // and also display the total number of vowels in the input file.
        System.out.println("The file has " + totalVowels + " different vowels.");
        System.out.println("Ended at:");
        printCurrTimestamp();
        printVowelsQty();
    }

    private static int getTotalVowels(String fPath) throws IOException {
        final Character[] chars = {'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowels = new HashSet<Character>(Arrays.asList(chars));
        System.out.println("get words");
        printCurrTimestamp();
        // Working from UniqueWords.Java, count and display the number of vowels in each input word,
        Set<String> words = TextFile.getDistinctWords(fPath, "[^a-zA-Z_0-9]");
        System.out.println("obtaining iterator");
        Iterator<String> it = words.iterator();
        int totalVowels = 0;
        while (it.hasNext()) {
            String currentWord = it.next();
            List<Character> currentChars = convertStringToCharList(currentWord);
            int tempCount = 0;
            Iterator<Character> currIt = currentChars.iterator();
            while (currIt.hasNext()) {
                //we need to make sure that the characters being tested are in the same "case"
                char currVowel = currIt.next();
                if (vowels.contains(Character.toUpperCase(currVowel))) {
                    tempCount += 1;
                    keepTrackVowelsQty(currVowel);
                }
            }
            System.out.println("The word " + currentWord + " has " + tempCount + " vowels.");
            totalVowels += tempCount;
        }
        return totalVowels;
    }

    //part of the exercise 20
    private static void keepTrackVowelsQty(char vowel) {
        char upperVowel = Character.toUpperCase(vowel);
        if (vowelsQty.containsKey(upperVowel)) {
            int currQty = vowelsQty.get(upperVowel);
            vowelsQty.replace(upperVowel, currQty + 1);
        } else {
            vowelsQty.put(upperVowel, 1);
        }
    }

    private static void printVowelsQty() {
        System.out.println(vowelsQty);
        int sum = 0;
        for (int i : vowelsQty.values()) {
            sum += i;
        }
        System.out.println("Total:" + sum);
    }
}
