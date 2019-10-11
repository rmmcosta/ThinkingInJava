package reusingclasses;

class Father {
    Father() {
        System.out.println("creating father");
    }
    static {
        System.out.println("static constructor initialized");
    }
    static int x = printcenas();
    static public int printcenas() {
        System.out.println("cenas");
        return 47;
    }
}

class Son23 extends Father{
    Son23() {
        System.out.println("creating son23");
    }
}


public class Ex23 {
    public static void main(String[] args) {
        //System.out.println(Father.x);
        Son23 son = new Son23();
        System.out.println(Father.x);
    }
}
