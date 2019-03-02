package holding;

import java.util.ArrayList;

public class ApplesAndOrangesWithGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i =0;i<3;i++)
            apples.add(new Apple());
        //apples.add(new Orange());
        for(int i=0;i<apples.size();i++)
            apples.get(i).getId();
        for (Apple a : apples
             ) {
            System.out.println(a.getId());
        }
    }
}
