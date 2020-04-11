package holdingYourObjects;

import java.util.ArrayList;
import java.util.List;

//: innerclasses/Sequence.java
// Holds a sequence of Objects.
interface Selector {
    boolean end();
    Object current();
    void next();
    void reset();
}
public class Sequence {
    private List items;
    private int next = 0;
    public Sequence() { items = new ArrayList(); }
    public void add(Object x) {
        items.add(x);
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { if(i < items.size()) i++; }
        public void reset() {
            i=0;
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for(int i = 0; i < 10; i++)
            sequence.add(i);
        sequence.add("coiso");
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        sequence.add("cenas");
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

        selector.reset();
        System.out.println();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}