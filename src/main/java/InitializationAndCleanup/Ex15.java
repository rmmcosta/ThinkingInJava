package InitializationAndCleanup;

public class Ex15 {
    String s;
    {
        System.out.println(s);
        this.s = "instance initialization";
        System.out.println(s);
    }
    Ex15(){
        System.out.println("default constructor");
        this.s = "Ana";
    }
    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        System.out.println(ex15.s);
    }
}
