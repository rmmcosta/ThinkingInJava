package polymorphism;

import java.util.Random;

class Rodent {
    public void eat() {
        System.out.println("Rodent eating");
    }
    public void walk() {
        System.out.println("I am walking");
    }
}

class Mouse extends Rodent {
    @Override
    public void eat() {
        System.out.println("MOuse eating");
    }
}

class Gerbil extends Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil eating");
    }
}

class Hamster extends Rodent {
    @Override
    public void eat() {
        System.out.println("Oh cute litle hamster is eating");
    }
}


public class Ex9 {
    static Rodent rodentGenerator() {
        Random r = new Random();
        Class<?> rodents[] = {Rodent.class, Mouse.class, Gerbil.class, Hamster.class};
        try {
            int idx = r.nextInt(rodents.length);
            return (Rodent)rodents[idx].newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate Rodents",e);
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
        for (Rodent r:rodents
             ) {
            go(r);
        }
    }
}
