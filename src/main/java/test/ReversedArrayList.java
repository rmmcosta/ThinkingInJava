package test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversedArray<T> extends ArrayList<T> {
    public ReversedArray(@NotNull Collection<? extends T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int pos = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return pos > -1;
                    }

                    @Override
                    public T next() {
                        return get(pos--);
                    }
                };
            }
        };
    }
}

public class ReversedArrayList {
    public static void main(String[] args) {
        ReversedArray<String> words = new ReversedArray<String>(Arrays.asList("Coiso e tal".split(" ")));
        for (String s : words) {
            System.out.println(s);
        }
        for (String s : words.reversed()) {
            System.out.println(s);
        }
    }
}
