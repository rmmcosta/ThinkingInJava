package reusingclasses;

class SelfCounter {
    private static int count;
    private int id = count++;
    public String toString() { return "SelfCounter " + id; }
}
class WithFinalFields {
    final SelfCounter scf = new SelfCounter();
    //the static final is always created first
    static final SelfCounter scsf = new SelfCounter();
    public String toString() {
        return "scf = " + scf + "\nscsf = " + scsf;
    }
}
public class E18_FinalFields {
    public static void main(String args[]) {
        System.out.println("First object:");
        System.out.println(new WithFinalFields());
        System.out.println("Second object:");
        System.out.println(new WithFinalFields());
    }
}