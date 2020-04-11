package reusingclasses;

class C1 {
    private String cenas(){
        return "cenas C1";
    }

    @Override
    public String toString() {
        return cenas();
    }
}

class C2 extends C1 {
    //@override
    private String cenas() {
        return "cenas C2";
    }

    @Override
    public String toString() {
        return cenas();
    }
}


public class OverridePrivateMethod {
    public static void main(String[] args) {
        C1 c1 = new C1();
        System.out.println(c1);
        C2 c2 = new C2();
        System.out.println(c2);
        C1 c1a = c2;
        System.out.println(c1a);
    }
}
