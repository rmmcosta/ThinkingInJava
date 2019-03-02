package InitializationAndCleanup;

public class StaticBlock {
    static int i;
    static String name;
    static {
        i = 10;
        name = "Ricardo";
    }
    public static void main(String[] args) {
        System.out.println(StaticBlock.i);
        System.out.println(name);
    }
}
