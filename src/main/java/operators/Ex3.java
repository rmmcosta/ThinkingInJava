package operators;

class Demo{
    float aFloat;
}

public class Ex3 {
    public static void change(Demo demo){
        demo.aFloat = 33f;
    }
    public static void change(Character c){
        c = 'A';
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.aFloat = 22f;
        System.out.println(demo.aFloat);
        Ex3.change(demo);
        System.out.println(demo.aFloat);
        Character c = new Character('X');
        System.out.println(c);
        Ex3.change(c);
        System.out.println(c);
    }
}
