package polymorphism;

class Cycle {
    public void ride() {
        System.out.println("riding my cycle");
    }
}

class Bicycle extends Cycle {
    public void ride() {
        System.out.println("riding my bicycle");
    }
}

class TriCycle extends Cycle {

}

public class Ex1 {
    static void go(Cycle c) {
        c.ride();
    }
    public static void main(String[] args) {
        Cycle c = new Cycle();
        c.ride();
        Bicycle b = new Bicycle();
        b.ride();
        TriCycle t = new TriCycle();
        t.ride();
        go(t);
        go(b);
    }
}
