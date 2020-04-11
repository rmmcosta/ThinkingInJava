package holdingYourObjects.PublicPolymorphism;

import java.sql.Timestamp;
import java.util.Date;

public class Gerbil extends Rodent {
    public Gerbil() {
        System.out.println("Gerbil created " + new Timestamp(new Date().getTime()));
    }

    @Override
    public void eat() {
        System.out.println("Gerbil eating");
    }
}


