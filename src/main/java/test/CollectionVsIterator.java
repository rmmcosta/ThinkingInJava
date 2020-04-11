package test;

import java.util.*;

class Smartphone {
    private final String maker, model;
    private final Map<String, Integer> makersAndModels = new HashMap<String, Integer>() {
        {
            put("Samsung", 1);
            put("Apple", 2);
            put("Huawei", 3);
            put("OnePlus", 4);
            put("S10", 1);
            put("Iphone 11", 2);
            put("P30", 3);
            put("7T Pro", 4);
        }
    };

    Smartphone(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model + ", " + this.maker;
    }

    public void ring() {
        System.out.println(this + " is Ringing...");
    }

    @Override
    public boolean equals(Object obj) {
        Smartphone s = (Smartphone) obj;
        return this.maker == s.maker && this.model == s.model;
    }

    @Override
    public int hashCode() {
        return makersAndModels.get(this.maker) + makersAndModels.get(this.model);
    }
}

class SmartphoneProcessor {
    public static void process(Collection<Smartphone> smartphones) {
        for (Smartphone s : smartphones) {
            System.out.println(s);
            s.ring();
        }
    }

    public static void process(Iterator<Smartphone> iterator) {
        Smartphone s;
        while (iterator.hasNext()) {
            s = iterator.next();
            System.out.println(s);
            s.ring();
        }
    }
}

class MyCollection extends AbstractCollection {
    private final String[] myWords;
    private int pos = 0;

    MyCollection(String[] myWords) {
        this.myWords = myWords;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                //System.out.println("my collection has next");
                return pos < myWords.length;
            }

            @Override
            public Object next() {
                //System.out.println("my collection next");
                return myWords[pos++];
            }
        };
    }

    @Override
    public int size() {
        return myWords.length;
    }

    public void reset() {
        pos = 0;
    }
}

class MyIterator implements Iterator {
    private final Iterator iterator;

    MyIterator(Collection collection) {
        iterator = collection.iterator();
    }

    @Override
    public boolean hasNext() {
        //System.out.println("My iterator has next");
        return iterator.hasNext();
    }

    @Override
    public Object next() {
        //System.out.println("My iterator next");
        Object object = iterator.next();
        doSomething(object);
        return object;
    }

    private void doSomething(Object object) {
        System.out.println("doing something else with: " + object);
    }
}

public class CollectionVsIterator {
    public static void main(String[] args) {
        List<Smartphone> list = new ArrayList<>();
        list.add(new Smartphone("Samsung", "S10"));
        list.add(new Smartphone("Huawei", "P30"));
        list.add(new Smartphone("Huawei", "P30"));
        list.add(new Smartphone("OnePlus", "7T Pro"));
        list.add(new Smartphone("Apple", "Iphone 11"));
        System.out.println("list");
        SmartphoneProcessor.process(list);
        System.out.println("list iterator");
        SmartphoneProcessor.process(list.iterator());
        //Now let's use a set. But in order for the set to ignore a second smartphone with
        //the same maker and model we need to override the hashcode and the equals
        Set<Smartphone> set = new HashSet<>(list);
        System.out.println("set");
        SmartphoneProcessor.process(set);
        System.out.println("set iterator");
        SmartphoneProcessor.process(set.iterator());

        MyCollection myCollection = new MyCollection(new String[]{"coiso", "e", "tal"});
        Iterator it = myCollection.iterator();
        System.out.println(myCollection.size());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        myCollection.reset();
        MyIterator myIterator = new MyIterator(myCollection);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
