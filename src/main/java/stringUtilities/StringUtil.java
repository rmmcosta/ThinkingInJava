package stringUtilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtil {
    public static Set<Character> convertStringToCharSet(String s){
        Set<Character> charSet = new HashSet<Character>();
        for(int i =0;i<s.length();i++){
            charSet.add(s.charAt(i));
        }
        return charSet;
    }
    public static List<Character> convertStringToCharList(String s) {
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            charList.add(s.charAt(i));
        }
        return charList;
    }
}
