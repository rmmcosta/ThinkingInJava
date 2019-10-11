package holdingYourObjects;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Word {
    private static Set<Word> words = new HashSet<Word>();
    private String _word;
    private int _count;
    public Word(String w, int count){
        _word = w;
        _count = count;
    }
    public static void countWord(String word){
        //System.out.println("time to count words");
        Iterator<Word> it = words.iterator();
        boolean noWord =true;
        while(it.hasNext()) {
            Word currWord = it.next();
            //System.out.println("currWord:" + currWord);
            //System.out.println("word:" + word);
            //System.out.println(currWord);
            //System.out.println(words);
            if(currWord._word.equals(word)) {
                currWord._count+=1;
                noWord = false;
                break;
            }
        }
        if(noWord) {
            words.add(new Word(word,1));
        }
    }
    public static void printWordsOcurrence() {
        //System.out.println(words);
        List<Word> sortedWords = words.stream()
                .sorted(Comparator.comparing(Word::getName))
                .collect(Collectors.toList());
        //System.out.println(sortedWords);
        Iterator<Word> it = sortedWords.iterator();
        while(it.hasNext()) {
            Word currWord = it.next();
            System.out.print(currWord._word + ": " + currWord._count);
            System.out.println();
        }
    }
    public String getName() {
        return this._word.toUpperCase();
    }
    @Override
    public String toString() {
        return this._word + ":" + this._count;
    }
}

public class Ex22 {
    public static void main(String[] args) {
        String fPath = "C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt";
        try {
            List<String> words = TextFile.getWords(fPath, "[^a-zA-Z_0-9]");
            //String[] arrWords = {"caco","cenas","caco","caco","cenas","caco"};
            //List<String> words = Arrays.asList(arrWords);
            for(String s:words) {
                Word.countWord(s);
            }
            Word.printWordsOcurrence();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
