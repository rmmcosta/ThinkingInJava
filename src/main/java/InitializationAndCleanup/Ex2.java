package InitializationAndCleanup;

public class Ex2 {
    String s1 = "coiso";
    String s2;
    public Ex2(){
        s2 = "e tal";
    }
    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        System.out.println(ex2.s1);
        System.out.println(ex2.s2);
    }
}
