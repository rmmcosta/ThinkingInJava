package holdingYourObjects;

import java.io.IOException;
import java.util.*;

import static stringUtilities.StringUtil.convertStringToCharList;
import static timeUtilities.Time.printCurrTimestamp;


public class Ex16 {
    public static void main(String[] args) throws IOException{
        // Create a Set of the vowels.
        System.out.println("Begin");
        printCurrTimestamp();
        Character[] chars = {'A','E','I','O','U'};
        Set<Character> vowels = new HashSet<Character>(Arrays.asList(chars));
        System.out.println("get words");
        printCurrTimestamp();
        // Working from UniqueWords.Java, count and display the number of vowels in each input word,
        Set<String> words = TextFile.getWords("C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt","[^a-zA-Z_0-9]");
        System.out.println("obtaining iterator");
        Iterator<String> it = words.iterator();
        int totalVowels = 0;
        while(it.hasNext()){
            String currentWord = it.next();
            List<Character> currentChars = convertStringToCharList(currentWord);
            int tempCount = 0;
            Iterator<Character> currIt = currentChars.iterator();
            while(currIt.hasNext()){
                //we need to make sure that the characters being tested are in the same "case"
                tempCount+=(vowels.contains(Character.toUpperCase(currIt.next()))?1:0);
            }
            System.out.println("The word " + currentWord+ " has " + tempCount + " vowels.");
            totalVowels+=tempCount;
        }

        // and also display the total number of vowels in the input file.
        System.out.println("The file has " + totalVowels + " different vowels.");
        System.out.println("Ended at:");
        printCurrTimestamp();
    }
}
