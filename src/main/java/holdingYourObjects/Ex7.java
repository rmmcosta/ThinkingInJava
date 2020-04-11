package holdingYourObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Cup {
    private String name;
    Cup(String s) {
        name = s;
    }
    @Override
    public String toString() {
        return name;
    }
}

public class Ex7 {
    public static void main(String[] args) {
        Cup[] arrCups = {new Cup("Liga Europa"),new Cup("Liga dos Campeões"),new Cup("Taça de Portugal"), new Cup("Copa América")};
        List<Cup> cups = new ArrayList<Cup>();
        System.out.println("1:"+cups);
        Collections.addAll(cups,arrCups);
        System.out.println("2:"+cups);
        List<Cup> subcups = cups.subList(1,2);
        System.out.println("3:"+cups);
        System.out.println("4:"+subcups);
        //cups.removeAll(subcups);
        //System.out.println("5:"+cups);
        //System.out.println("6:"+subcups);
        //for(Cup c:subcups) {
        //    System.out.println(c);
        //}
        //System.out.println("7:"+subcups.size());
        //java.util.ConcurrentModificationException
        subcups.clear();
        System.out.println("5:"+cups);
        System.out.println("6:"+subcups);
    }
}
