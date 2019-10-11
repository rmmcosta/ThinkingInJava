package test;

class Father15 {
    public void cenas() {
        System.out.println("cenas");
    }
}

class Son15 extends Father15 {
    public void coisas() {
        System.out.println("coisas");
    }
}

class Son152 extends Father15 {
    public void outrasCoisas() {
        System.out.println("outras coisas");
    }
}

public class Downcast {
    static void go(Father15 f) {
        f.cenas();
        if (f instanceof Son15) {
            ((Son15) f).coisas();
        }
        if (f instanceof Son152) {
            ((Son152) f).outrasCoisas();
        }
    }

    public static void main(String[] args) {
        Father15 f = new Son15();
        go(f);
        Father15 f2 = new Son152();
        go(f2);
    }
}
