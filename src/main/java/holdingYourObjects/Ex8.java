package holdingYourObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Gerbil8 {
    private static int gerbilNumber=0;
    private int id;
    Gerbil8() {
        gerbilNumber++;
        id = gerbilNumber;
    }
    public void hop() {
        System.out.println("Gerbil " + id + " is hoping...");
    }
    public int id() {
        return id;
    }
}

public class Ex8 {
    public static void main(String[] args) {
        List<Gerbil8> gerbils = new ArrayList<Gerbil8>();
        for(int i=0;i<10;i++) {
            gerbils.add(new Gerbil8());
        }
        Iterator<Gerbil8> it = gerbils.iterator();
        Gerbil8 g;
        while(it.hasNext()) {
            g = it.next();
            g.hop();
            if(g.id()%2==0){
                it.remove();
            }
        }
        for(Iterator<Gerbil8> iter = gerbils.iterator();iter.hasNext();iter.next().hop());
    }
}
