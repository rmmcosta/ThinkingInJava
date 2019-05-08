package holdingYourObjects.PublicPolymorphism;

import java.sql.Timestamp;
import java.util.Date;

public class Rodent {
    Cheese c = new Cheese();

    public Rodent() {
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


