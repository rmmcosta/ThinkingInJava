package test;

import java.util.ArrayList;
import java.util.Iterator;

public class TestCollections {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(10);
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
