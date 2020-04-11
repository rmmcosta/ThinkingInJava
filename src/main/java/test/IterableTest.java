package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static common.Common.charArray2CharacterArray;

public class IterableTest {
    public static <T> void process(Iterable<T> iterable) {
        for (T t : iterable) {
            System.out.println(t);
        }
    }
    public static void main(String[] args) {
        process(Arrays.asList(12,3,35,5));
        process(Arrays.asList("Coisio", "e", "tal"));
        process(Arrays.asList('C', 'O'));
        String[] words = "coiso e tal e cenas e mais cenas".split(" ");
        process(Arrays.asList(words));
        char[] chars = "coiso".toCharArray();
        process(Arrays.asList(chars));
        Character[] characters = charArray2CharacterArray(chars);
        process(Arrays.asList(characters));
    }
}
