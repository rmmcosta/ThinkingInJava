package operators;

public class Ex2 {
    int xpto;
    public static void main(String[] args) {
        Character c = new Character('x');
        char c1 = 'y';
        Character c2 = new Character(c1);
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        c2 = c1;
        c1='z';
        c2 = 'b';
        c = c2;
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        c2 = 'd';
        System.out.println(c);
        System.out.println(c2);
        Ex2 ex21 = new Ex2();
        ex21.xpto = 5;
        Ex2 ex22 = new Ex2();
        ex22.xpto = 7;
        System.out.println(ex21.xpto);
        System.out.println(ex22.xpto);
        ex22 = ex21;
        System.out.println(ex21.xpto);
        System.out.println(ex22.xpto);
        ex21.xpto = 13;
        System.out.println(ex21.xpto);
        System.out.println(ex22.xpto);

    }
}
