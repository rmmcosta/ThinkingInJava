package test;

import java.util.*;

class Pet {

}

class Rat extends Pet {
    @Override
    public String toString() {
        return "Rat";
    }
}

class Manx extends Pet {
    @Override
    public String toString() {
        return "Manx";
    }
}

class Cymric extends Pet {
    @Override
    public String toString() {
        return "Cymric";
    }
}

public class ArrayListTests {
    private static void print2Lists(List l1, List l2) {
        System.out.println("The lists: " + l1 + ", " + l2);
    }

    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<Pet>();
        Collections.addAll(pets, new Manx(), new Cymric(), new Rat());
        System.out.println(pets);

        //Integer[] intArr = new Integer[5];
        List<Integer> integers = Arrays.<Integer>asList(1, 2, 3, 4, 5);
        List<Integer> integers2 = Arrays.<Integer>asList(new Integer[integers.size()]);
        print2Lists(integers, integers2);
        ListIterator<Integer> listIterator = integers.listIterator();

        //fill the second list in reverse order
        int count = integers2.size() - 1;
        while (listIterator.hasNext()) {
            integers2.set(count--, listIterator.next());
        }
        System.out.println("1st 2 lists");
        print2Lists(integers, integers2);

        //another solution
        List<Integer> integers3 = Arrays.<Integer>asList(new Integer[integers.size()]);
        ListIterator<Integer> listIterator3 = integers3.listIterator();
        listIterator = integers.listIterator(integers.size());
        do {
            //need to do the next first
            //only after that we can do the set
            listIterator3.next();
            listIterator3.set(listIterator.previous());
            //System.out.println(listIterator.previous());
        } while (listIterator.hasPrevious());
        System.out.println("2nd 2 lists");
        print2Lists(integers, integers3);
        List l = new ArrayList();
        Collections.addAll(l, 50, 40, 30, 40, 20);
        System.out.println(l);
        l.add(33);
        System.out.println(l);
        ListIterator iterator = l.listIterator();
        //let's add 2 integers to the beginning of the list
        //by using the iterator.add() method
        //iterator.next();
        iterator.add(44);
        System.out.println(l);
        //iterator.next();
        iterator.add(55);
        System.out.println(l);

    }
}
