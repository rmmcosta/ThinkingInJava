package test;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class FileWordsParser {
    private List<String> words;
    private String filePath;

    public FileWordsParser(String filePath) {
        words = new ArrayList<>();
        this.filePath = filePath;
    }

    public List<String> wordsParse() {
        //to read words in a file we can use buffer reader or scanner
        //let's go with the buffer reader
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null && line != "") {
//                System.out.println("line: " + line);
                words.addAll(Arrays.asList(line.split("[ ,.;]")));
            }
//            System.out.println(words);
            bufferedReader.close();
            fileReader.close();
            return words;

        } catch (FileNotFoundException e) {
            System.out.println("Unable to located the specified file: " + filePath);
            System.err.println("Exception: " + e);
            return null;
        } catch (Exception e) {
            System.out.println("An error has occurred while trying to open the specified file!");
            System.err.println("Exception: " + e);
            return null;
        }
    }
}

class FileWordsParserTest {
    public static void main(String[] args) {
        /*List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList("Ricardo", "Ana", "João", "Ricardo"));
        System.out.println(names);
        Set<String> words = new TreeSet<String>(names);
        System.out.println(words);*/
        FileWordsParser fileWordsParser = new FileWordsParser("/home/ricardo/IdeaProjects/Github/ThinkingInJava/TextDocument.txt");
        System.out.println(fileWordsParser.wordsParse());
    }
}
