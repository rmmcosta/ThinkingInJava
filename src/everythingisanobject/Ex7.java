package everythingisanobject;

class StaticTest {
    static int i = 47;
}

class Incrementable {
    static void increment() { StaticTest.i++; }
    public void nonStaticInc (){
        increment();
    }
}

public class Ex7 {
    public static void main(String[] args) {
        Incrementable sf = new Incrementable();
        sf.increment();
        System.out.println(StaticTest.i);
        Incrementable.increment();
        System.out.println(StaticTest.i);
        sf.nonStaticInc();
        System.out.println(StaticTest.i);
    }
}
