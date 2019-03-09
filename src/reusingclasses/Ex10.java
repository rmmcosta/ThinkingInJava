package reusingclasses;

class Component12 {
    Component12(int i) {
        System.out.println(i+"Class Component1 " + this.toString());
    }
}

class Component22 {
    Component22(int i) {
        System.out.println(i+"Class Component2 " + this.toString());
    }
}

class Component32 {
    Component32(int i) {
        System.out.println(i+"Class Component3 " + this.toString());
    }
}

class Root2 {
    Component12 c1;
    Component22 c2;
    Component32 c3;

    Root2(int i) {
        c1 = new Component12(i);
        c2 = new Component22(i);
        c3 = new Component32(i);
        System.out.println(i+"Class Root " + this.toString());
    }
}

class Stem2 extends Root2 {
    Component12 c1;
    Component22 c2;
    Component32 c3;

    Stem2(int i) {
        super(i);
        c1 = new Component12(i);
        c2 = new Component22(i);
        c3 = new Component32(i);
        System.out.println(i+"Class Stem " + this.toString());
    }
}

public class Ex10 {
    public static void main(String[] args) {
        Stem2 s = new Stem2(13);
    }
}
