package holdingYourObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//: innerclasses/Ex9.java
// Holds a Ex9 of Objects.
public class Ex9 {
    private List items;
    private int next = 0;
    public Ex9() { items = new ArrayList(); }
    public void add(Object x) {
        items.add(x);
    }
    private class Ex9Selector implements Iterator {

        @Override
        public boolean hasNext() {
            return next<items.size();
        }
        @Override
        public Object next() { return items.get(next++);}
    }
    public Iterator selector() {
        next=0;
        return new Ex9Selector();
    }
    public static void main(String[] args) {
        Ex9 Ex9 = new Ex9();
        for(int i = 0; i < 10; i++)
            Ex9.add(i);
        Ex9.add("coiso");
        Iterator selector = Ex9.selector();
        while(selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }

        Ex9.add("cenas");
        while(selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }

        selector = Ex9.selector();
        System.out.println();
        while(selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }
    }
}