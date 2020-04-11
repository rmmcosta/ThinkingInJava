package reusingclasses;


import static operators.Utils.print;

class Cleanser3 {
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

public class Ex11 {
    private final Cleanser3 cl3 = new Cleanser3();

    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {
        Ex11 x = new Ex11();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }

    public void append(String s){
        cl3.append(s);
    }

    public void dilute(){
        cl3.dilute();
    }

    public void apply() {
        cl3.apply();
    }

    public void scrub() {
        cl3.append(" Detergent.scrub()");
        cl3.scrub();
    }

    public String toString() {
        return cl3.toString();
    }
} /* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~
