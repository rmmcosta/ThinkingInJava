package operators;

class Dog{
    String name;
    String says;
}

public class Ex6 {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.name = "spot";
        d1.says = "Ruff!";
        Dog d2 = new Dog();
        d2.name = "angel";
        d2.says = "Wurf!";
        System.out.println(d1.name);
        System.out.println(d1.says);
        System.out.println(d2.name);
        System.out.println(d2.says);
        System.out.println(d1==d2);
        System.out.println(d1.equals(d2));
        Dog d3 = d2;
        System.out.println(d2==d3);
        System.out.println(d2.equals(d3));
    }
}
