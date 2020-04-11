package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class MyList {
    private List list;

    public MyList(Object[] array) {
        this.list = Arrays.asList(array);
    }

    public <T> T[] toArray(T[] a) {
        int size = list.size();
        T[] tempArray;
        if (a.length >= size) {
            tempArray = a;
        } else {
            tempArray = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }
        //now let's use an iterator
        //and if the iterator runs out of
        //values but the a array still has available positions
        //
        Iterator iterator = list.iterator();
        for (int i = 0; i < tempArray.length; i++) {
            if (iterator.hasNext()) {
                tempArray[i] = (T) iterator.next();
            }
        }
        return tempArray;
    }
}

public class ToArrayTest {
    public static void main(String[] args) {
        int[] myNumbers = {1, 2, 3, 4, 5};
        Integer[] integers = Arrays.stream(myNumbers).boxed().toArray(Integer[]::new);
        List<Integer> myListNumbers = new ArrayList<Integer>(Arrays.asList(integers));
        Integer[] myNumbersAgain = new Integer[myNumbers.length];
        myListNumbers.toArray(myNumbersAgain);
        for (int i : myNumbersAgain) {
            System.out.println(i);
        }

        Object[] objects = {1, 2, 3, 4};
        List list = new ArrayList(Arrays.asList(objects));
        Integer[] myInts1 = (Integer[]) list.toArray(new Integer[10]);
        for (Integer i : myInts1) {
            if (i != null) {
                System.out.println(i);
            }
        }
        MyList myList = new MyList(objects);
        Integer[] myInts = myList.toArray(new Integer[0]);
        for (Integer i : myInts) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}
