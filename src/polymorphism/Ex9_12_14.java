package polymorphism;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

class Cheese {
    private static int refCount = 0;

    Cheese() {
        refCount++;
        System.out.println("I am the cheese. Come bit me!");
    }

    public static void status() {
        System.out.println(refCount + " Cheese Objects beeing used!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cheese finalized!");
    }

    public void dispose() throws Throwable {
        if (--refCount == 0) {
            finalize();
        } else {
            System.out.println("Cheese objects are still being used!");
        }
    }
}

class Rodent {
    Cheese c = new Cheese();

    Rodent() {
        System.out.println("Rodent created " + new Timestamp(new Date().getTime()));
        //c = new Cheese();
    }

    public void eat() {
        System.out.println("Rodent eating");
    }

    public void walk() {
        System.out.println("I am walking");
    }

    public void dispose() {
        try {
            this.c.dispose();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Disposing " + this);
    }
}

class Mouse extends Rodent {
    Cheese c;

    Mouse() {
        System.out.println("Mouse created " + new Timestamp(new Date().getTime()));
        c = new Cheese();
    }

    @Override
    public void eat() {
        System.out.println("MOuse eating");
    }

    @Override
    public void dispose() {
        try {
            c.dispose();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        super.dispose();
    }
}

class Gerbil extends Rodent {
    Gerbil() {
        System.out.println("Gerbil created " + new Timestamp(new Date().getTime()));
    }

    @Override
    public void eat() {
        System.out.println("Gerbil eating");
    }
}

class Hamster extends Rodent {
    Hamster() {
        System.out.println("Rodent created " + new Timestamp(new Date().getTime()));
    }

    @Override
    public void eat() {
        System.out.println("Oh cute litle hamster is eating");
    }
}


public class Ex9_12_14 {
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
        Rodent rodents[] = new Rodent[5];
        for (int i = 0; i < rodents.length; i++) {
            rodents[i] = rodentGenerator();
        }
        for (Rodent r : rodents
        ) {
            go(r);
        }

        Mouse m = new Mouse();
        Cheese.status();
        m.dispose();
        for (Rodent r:rodents
             ) {
            r.dispose();
            Cheese.status();
        }
    }
}
