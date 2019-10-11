package holdingYourObjects;

import java.util.*;

class Cena {

}

public class IteratorTest {
    public static Cena getNext(Iterator<Cena> i) {
        if(i.hasNext()) {
            System.out.println("has next");
            return i.next();
        }
        System.out.println("no next value");
        return null;
    }
    public static void main(String[] args) {
        List<Cena> cenas = new ArrayList<Cena>();
        cenas.add(new Cena());
        Iterator<Cena> i = cenas.iterator();
        System.out.println(getNext(i));
        System.out.println(getNext(i));
        Set<Cena> sCenas =new HashSet<Cena>();
        sCenas.add(new Cena());
        i = sCenas.iterator();
        System.out.println(getNext(i));
        System.out.println(getNext(i));
    }
}
