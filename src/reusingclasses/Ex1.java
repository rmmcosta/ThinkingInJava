package reusingclasses;

class Simple {
    String s = "Ricarod";
    @Override
    public String toString() {
        return s;
    }
}

class Second {
    Simple simple;
    public void present(){
        simple = new Simple();
        System.out.println(simple);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Second second = new Second();
        second.present();
    }
}
