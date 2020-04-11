package reusingclasses;

class Base8 {
    Base8(int i){
        System.out.println("Base constructor:" + i);
    }
}

class DerivedClass8 extends Base8 {
    DerivedClass8(){
        super(6);
        System.out.println("Derived Class with 6");
    }
    DerivedClass8(int i){
        super(i);
        System.out.println("Derived class with " + i);
    }
}

public class Ex8 {
    public static void main(String[] args) {
        DerivedClass8 dc8 = new DerivedClass8();
        DerivedClass8 dc81 = new DerivedClass8(556);
    }
}
