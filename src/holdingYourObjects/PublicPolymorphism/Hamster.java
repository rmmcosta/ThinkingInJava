package holdingYourObjects.PublicPolymorphism;

import java.sql.Timestamp;
import java.util.Date;

public class Hamster extends Rodent {
    public Hamster() {
        System.out.println("Rodent created " + new Timestamp(new Date().getTime()));
    }

    @Override
    public void eat() {
        System.out.println("Oh cute litle hamster is eating");
    }
}


