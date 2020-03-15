package test;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static common.Common.charArray2CharacterArray;

public class Vowels {
    private static final String vowels = "aeiouAEIOU";
    private static final Character[] vowelsArray = charArray2CharacterArray(vowels.toCharArray());
    private static final Set<Character> vowelsSet = new HashSet<Character>(Arrays.asList(vowelsArray));

    // all the get number vowels methods give us the number of vowels in the given words
    public static List<Integer> getNumberVowels(List<String> words) {
        List<Integer> numberVowels = new ArrayList<>();
        for (String word : words) {
            numberVowels.add(getNumberVowels(word));
        }
        return numberVowels;
    }

    public static Map<String, Integer> getNumberVowels(Set<String> words) {
        Map<String, Integer> numberVowels = new HashMap<String, Integer>();
        for (String word : words) {
            numberVowels.put(word, getNumberVowels(word));
        }
        return numberVowels;
    }

    public static Integer getNumberVowels(String word) {
        //if we create a new character list (if we use a set we will only count once for each vowel) for the word
        //we will be able to see which elements are contained in the
        //vowels set
        List<Character> wordCharList = getVowelsFromWord(word);
        return wordCharList.size();
    }

    @NotNull
    public static List<Character> getVowelsFromWord(String word) {
        char[] chars = word.toCharArray();
        Character[] characters = charArray2CharacterArray(chars);
        List<Character> wordCharList = new ArrayList<>(Arrays.asList(characters));
        wordCharList.retainAll(vowelsSet);
        return wordCharList;
    }

    //the getVowelsCount gives us how many times a given vowel appears in the given words list
    public static Map<Character, Integer> getVowelsCount(List<String> words) {
        Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
        for (String word : words) {
            List<Character> vowelsInWord = getVowelsFromWord(word);
            for (Character c : vowelsInWord) {
                if (tempMap.containsKey(c)) {
                    tempMap.replace(c, tempMap.get(c) + 1);
                } else {
                    tempMap.put(c, 1);
                }
            }
        }
        return tempMap;
    }

    public static void main(String[] args) {
//        System.out.println(vowelsSet);
        FileWordsParser fileWordsParser = new FileWordsParser("/home/ricardo/IdeaProjects/Github/ThinkingInJava/TextDocument.txt");
        List<String> words = fileWordsParser.wordsParse();
        System.out.println(words);
        List<Integer> numberOfVowels = getNumberVowels(words);
        System.out.println(numberOfVowels);
        //https://www.baeldung.com/java-stream-sum
        int sum = numberOfVowels.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        Map<String, Integer> vowelsMap = getNumberVowels(new HashSet<>(words));
        System.out.println(vowelsMap);
        sum = vowelsMap.values().stream().reduce(0, Integer::sum);
        System.out.println(sum);
        LinkedHashMap<String, Integer> sortedVowelsMap = new LinkedHashMap<>();
        //we need to append to the hashmap the sorted pairs
        //to do that, we need to extract the keys and sort them
        //and append them afterwards
//        System.out.println(Arrays.toString(vowelsMap.keySet().toArray()));
        Object[] sortedKeys = vowelsMap.keySet().toArray();
        //we can pass a string array to the toArray method in order for the method
        //to return an array of string or we can work with the above object array
        String[] sortedStringKeys = vowelsMap.keySet().toArray(new String[0]);
        System.out.println("string array: " + Arrays.toString(sortedStringKeys));

        System.out.println("object array: " + Arrays.toString(sortedKeys));
        Arrays.sort(sortedKeys);
        //if we want to sort it ignoring upper and lower cases
        //we need to work with the string array because that way we can
        //pass a 2nd input to the sort String.CASE_INSENSITIVE_ORDER
        System.out.println("sorted object array: " + Arrays.toString(sortedKeys));
        for (Object key : sortedKeys) {
            sortedVowelsMap.put((String) key, vowelsMap.get(key));
        }
        System.out.println("sorted map: " + sortedVowelsMap);

        Map<Character, Integer> vowelsCount = getVowelsCount(words);
        System.out.println(vowelsCount);
    }
}

class MyWord {
    private String word;
    private Integer count;
    private static Set<MyWord> myWords = new HashSet<MyWord>();

    public MyWord(String word) {
        this.word = word;
        count = 1;
        MyWord existentMyWord = contains(word);
        if (existentMyWord == null) {
            myWords.add(this);
        } else {
            existentMyWord.increment();
        }
    }

    private void increment() {
        count++;
    }

    public static Set<MyWord> getWords() {
        return myWords;
    }

    public static void printWordCounts() {
        for (MyWord myWord : myWords) {
            System.out.println(myWord);
        }
    }

    @Override
    public String toString() {
        return this.word + ": " + this.count;
    }

    public static MyWord contains(String word) {
        //System.out.println("mywords: " + myWords + ", passed word: " + word);
        for (MyWord myWord : myWords) {
            //strings must be compared with equals and not ==
            if (myWord.word.equals(word)) {
                //System.out.println("found match");
                return myWord;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FileWordsParser fileWordsParser = new FileWordsParser("/home/ricardo/IdeaProjects/Github/ThinkingInJava/TextDocument.txt");
        List<String> words = fileWordsParser.wordsParse();
        for (String word : words) {
            new MyWord(word);
        }
        printWordCounts();
    }
}
