package reusingclasses;

class Amphibian {
    public void makeNoise() {
        System.out.println("Amphibian, Amphibian");
    }
    public void eat() {
        System.out.println("eating");
    }
}

class Frog extends Amphibian {
    public void jump() {
        System.out.println("jumping");
    }
}

public class Ex16 {
    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.jump();
        frog.eat();
        frog.makeNoise();
    }
}
