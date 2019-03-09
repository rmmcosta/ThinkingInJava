package reusingclasses;

class OverloadedClass {
    public void pCenas() {
        System.out.println("Cenas");
    }
    public void pCenas(int i) {
        System.out.println("Cenas "+i);
    }
    public void pCenas(String s) {
        System.out.println("Cenas " + s);
    }
    public void pCenas(boolean b) {
        System.out.println("Cenas " + b);
    }
}

class DerivedOverloadedClass extends OverloadedClass {
    public void pCenas(float f) {
        System.out.println("Derived " + f);
    }
}

public class Ex13 {
    public static void main(String[] args) {
        DerivedOverloadedClass doc = new DerivedOverloadedClass();
        doc.pCenas(0.2f);
        doc.pCenas("Ricardo");
        doc.pCenas(5);
        doc.pCenas();
        doc.pCenas(true);
    }
}
