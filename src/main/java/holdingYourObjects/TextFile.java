package holdingYourObjects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextFile{
    public static Set getDistinctWords(String filePath, String ignoreRegex) throws IOException {
        Set<String> words = new HashSet<String>();
        String data;
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        data = data.replaceAll(ignoreRegex," ");
        //System.out.println(data);
        data = data.trim().replaceAll("\\s{2,}", " ");
        Collections.addAll(words,data.split(" "));
        //Iterator<String> it = words.iterator();
        return words;
    }

    public static List getWords(String filePath, String ignoreRegex) throws IOException {
        List<String> words = new ArrayList<String>();
        String data;
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        data = data.replaceAll(ignoreRegex," ");
        //System.out.println(data);
        data = data.trim().replaceAll("\\s{2,}", " ");
        Collections.addAll(words,data.split(" "));
        //Iterator<String> it = words.iterator();
        return words;
    }

    public static void main(String[] args) throws IOException {
        Set<String> words = new TreeSet<String>(
                TextFile.getDistinctWords("/home/rmmcosta/Documents/ThinkingInJava/" +
                "TextDocument.txt","[^a-zA-Z_0-9]"));
        //for windows the previous path must be adjusted
        //http://tutorials.jenkov.com/java-nio/path.html
        System.out.println(words);
        System.out.println(words.size());
        Iterator<String> it = words.iterator();
        System.out.println("next:"+it.next());
        System.out.println("next:"+it.next());
        Set<String> words2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words2.addAll(TextFile.getDistinctWords("/home/rmmcosta/Documents/ThinkingInJava/" +
                "TextDocument.txt","[^a-zA-Z_0-9]"));
        System.out.println(words2);
        System.out.println(words2.size());
        Iterator<String> it2 = words2.iterator();
        System.out.println("next:"+it2.next());
        System.out.println("next:"+it2.next());
    }
}
