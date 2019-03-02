package reusingclasses;

class Base {
    public Base() {
        System.out.println("Base constructor");
    }
}

class Son extends Base {
    public Son() {
        System.out.println("Son constructor");
    }
}


public class Ex3 extends Son {
    public static void main(String[] args) {
        Ex3 ex3 = new Ex3();
    }
}
