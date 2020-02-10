package holdingYourObjects;

//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.

import java.util.*;

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        for (Snow s : snow2) {
            System.out.println(s);
        }

        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());
        for(Snow s:snow3){
            System.out.println(s);
        }
        // Give a hint using an
        // explicit type argument specification:
        // in newer versions of java this isn't needed anymore
        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy());
        for(Snow s:snow4){
            System.out.println(s);
        }
        System.out.println(snow4);
    }
}