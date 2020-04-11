package innerclasses;

public class NewInner {
    public static void main(String[] args){
        Outer o = new Outer();
        Outer.Inner i = o.new Inner();
        i.printcenas();
        System.out.println(i);
        System.out.println(i.getOuter());
    }
}
