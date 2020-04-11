package AccessControl;

public class Ex5Test {
    public static void main(String[] args) {
        Ex5 ex5 = new Ex5();
        System.out.println(ex5.sProtec);
        System.out.println(ex5.sPublic);
        ex5.printProtected();
        ex5.printPublic();
    }
}
