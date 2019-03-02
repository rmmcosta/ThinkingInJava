package reusingclasses;

class A {
    public A() {
        System.out.println("A constructor");
    }
}

class B {
    public B() {
        System.out.println("B constructor");
    }
}

class C extends A {
    B theB = new B();
}


public class Ex5 {
    public static void main(String[] args) {
        C theC = new C();
    }
}
