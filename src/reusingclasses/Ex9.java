package reusingclasses;

class Component1 {
    Component1() {
        System.out.println("Class Component1 " + this.toString());
    }
}

class Component2 {
    Component2() {
        System.out.println("Class Component2 " + this.toString());
    }
}

class Component3 {
    Component3() {
        System.out.println("Class Component3 " + this.toString());
    }
}

class Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    Root() {
        c1 = new Component1();
        c2 = new Component2();
        c3 = new Component3();
        System.out.println("Class Root " + this.toString());
    }
}

class Stem extends Root {
    Component1 c1;
    Component2 c2;
    Component3 c3;

    Stem() {
        c1 = new Component1();
        c2 = new Component2();
        c3 = new Component3();
        System.out.println("Class Stem " + this.toString());
    }
}

public class Ex9 {
    public static void main(String[] args) {
        Stem s = new Stem();
    }
}
