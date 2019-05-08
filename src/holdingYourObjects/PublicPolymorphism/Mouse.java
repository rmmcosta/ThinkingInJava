package holdingYourObjects.PublicPolymorphism;

import java.sql.Timestamp;
import java.util.Date;

public class Mouse extends Rodent {
    Cheese c;

    public Mouse() {
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


