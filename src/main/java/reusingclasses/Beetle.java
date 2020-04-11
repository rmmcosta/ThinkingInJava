package reusingclasses;

import static reusingclasses.Utilities.print;

class Utilities {
    public static void print(String s) {
        System.out.println(s);
    }
}

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 =
            printInit("static Insect.x1 initialized");
    static int printInit(String s) {
        print(s);
        return 47;
    }
}

class V2 extends Beetle{

}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");
    public static void main(String[] args) {
        //print("Beetle constructor");
        //Beetle b = new Beetle();
        V2 v2 = new V2();
    }
}
