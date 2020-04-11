package holdingYourObjects;

import java.util.ArrayList;

class GreenApple extends Apple{

}

class GoldApple extends Apple{

}

class RanetaApple extends Apple{

}

public class GenericsAndUpcasting {
    public static void main(String[] args){
        GreenApple ga = new GreenApple();
        GoldApple goa = new GoldApple();
        RanetaApple ra = new RanetaApple();
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(ga);
        apples.add(goa);
        apples.add(ra);
        for (Apple a: apples
             ) {
            System.out.println(a);
        }
    }
}
