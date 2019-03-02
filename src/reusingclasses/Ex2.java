package reusingclasses;

public class Ex2 extends Detergent {
    @Override
    public void scrub() {
        System.out.println("Overrided scrub");
        super.scrub();
    }

    public void sterelize() {
        System.out.println("Sterilizing...");
    }
    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        System.out.println(ex2);
        ex2.dilute();
        System.out.println(ex2);
        ex2.foam();
        System.out.println(ex2);
        ex2.scrub();
        System.out.println(ex2);
        ex2.sterelize();
    }
}
