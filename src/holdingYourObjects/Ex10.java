package holdingYourObjects;

import holdingYourObjects.PublicPolymorphism.*;
import holdingYourObjects.PublicPolymorphism.Gerbil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex10 {
    static Rodent rodentGenerator() {
        Random r = new Random();
        Class<?> rodents[] = {Rodent.class, Mouse.class, Gerbil.class, Hamster.class};
        try {
            int idx = r.nextInt(rodents.length);
            return (Rodent) rodents[idx].newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate Rodents", e);
        }
    }

    public static void go(Rodent r) {
        r.eat();
        r.walk();
        r.eat();
        r.walk();
    }

    public static void main(String[] args) {
        List<Rodent> rodents = new ArrayList<Rodent>();
        for (int i = 0; i < 5; i++) {
            rodents.add(rodentGenerator());
        }
        Iterator<Rodent> it = rodents.iterator();
        while(it.hasNext())
            go(it.next());

        Mouse m = new Mouse();
        Cheese.status();
        m.dispose();
        it = rodents.iterator();
        while(it.hasNext()) {
            it.next().dispose();
            Cheese.status();
        }
    }
}
