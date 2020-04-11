package reusingclasses;

class Amphibian2 {
    public void makeNoise() {
        System.out.println("Amphibian, Amphibian");
    }
    public void eat() {
        System.out.println("Amphibian eating");
    }
}

class Frog2 extends Amphibian2 {
    public void jump() {
        System.out.println("Jumping");
    }
    @Override
    public void makeNoise(){
        System.out.println("Quark, Quark");
    }
    @Override
    public void eat() {
        System.out.println("Frog eating");
    }
}


public class Ex17 {
    public static void main(String[] args) {
        Frog2 f = new Frog2();
        f.eat();
        f.jump();
        f.makeNoise();
        Amphibian2 a = new Frog2();
        a.eat();
        ((Frog2) a).jump();
        a.makeNoise();
        Amphibian2 a2 = new Amphibian2();
        a2.makeNoise();
        a2.eat();
        ((Frog2)a2).jump();//cannot do the cast. It's not a Frog
    }
}
