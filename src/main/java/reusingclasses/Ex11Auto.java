package reusingclasses;


import static operators.Utils.print;

class Cleanser2 {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        print(x);
    }
}

public class Ex11Auto {
    private final MyCleanser2 cleanser2 = new MyCleanser2();

    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {
        Ex11Auto x = new Ex11Auto();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }

    public void append(String a) {
        cleanser2.append(a);
    }

    public void dilute() {
        cleanser2.dilute();
    }

    public void apply() {
        cleanser2.apply();
    }

    public void scrub() {
        cleanser2.scrub();
    }

    public String toString() {
        return cleanser2.toString();
    }

    private class MyCleanser2 extends Cleanser2 {
        // Change a method:
        public void scrub() {
            append(" Detergent.scrub()");
            super.scrub(); // Call base-class version
        }
    }
} /* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~
