package reusingclasses;

class A7 {
    public A7(String s) {
        System.out.println("A constructor:" + s);
    }

    public A7() {
        System.out.println("A default constructor");
    }
}

class B7 {
    public B7(int i) {
        System.out.println("B constructor:" + i);
    }
}

class C7 extends A7 {
    B7 theB;

    public C7(String s, int i) {
        //super(s);
        theB = new B7(i);
    }
}


public class Ex7 {
    public static void main(String[] args) {
        C7 theC = new C7("Nabo", 10);
        A7 a7test = new A7();
        A7 a7test2 = new A7("Jair");
    }
}
