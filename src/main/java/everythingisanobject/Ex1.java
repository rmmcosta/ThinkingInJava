package everythingisanobject;

public class Ex1 {
    static int aStaticInt;
    static char aStaticChar;
    int anInt;
    char aChar;

    public static void main(String[] args) {
        System.out.println("Static char:" + aStaticChar);
        System.out.println("Static int:" + aStaticInt);

        Ex1 ex1 = new Ex1();
        System.out.println("instance char:" + ex1.aChar);
        System.out.println("instance int:" +    ex1.anInt);
    }
}
