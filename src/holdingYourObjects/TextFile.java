package holdingYourObjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextFile{
    public static Set getWords(String filePath, String ignoreRegex) throws IOException {
        Set<String> words = new HashSet<String>();
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        data = data.replaceAll(ignoreRegex," ");
        System.out.println(data);
        data = data.trim().replaceAll("\\s{2,}", " ");
        Collections.addAll(words,data.split(" "));
        Iterator<String> it = words.iterator();
        return words;
    }

    public static void main(String[] args) throws IOException {
        Set<String> words = new TreeSet<String>(
                TextFile.getWords("C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt","[^a-zA-Z_0-9]"));
        System.out.println(words);
        System.out.println(words.size());
        Iterator<String> it = words.iterator();
        System.out.println("next:"+it.next());
        System.out.println("next:"+it.next());
        Set<String> words2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words2.addAll(TextFile.getWords("C:\\Users\\Ricardo\\Desktop" +
                "\\New Text Document.txt","[^a-zA-Z_0-9]"));
        System.out.println(words2);
        System.out.println(words2.size());
        Iterator<String> it2 = words2.iterator();
        System.out.println("next:"+it2.next());
        System.out.println("next:"+it2.next());
    }
}
