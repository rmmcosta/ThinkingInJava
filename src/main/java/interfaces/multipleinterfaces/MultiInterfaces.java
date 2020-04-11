package interfaces.multipleinterfaces;

public interface MultiInterfaces {
    void a();
}

interface I1 extends MultiInterfaces {
    void i1();
}

interface I2 extends MultiInterfaces {
    void i2();
}

interface I3 extends I1,I2 {

}

class C3 implements I3 {
    public void i1() {
        System.out.println("I1");
    }

    public void i2(){
        System.out.println("I2");
    }

    public void a(){
        System.out.println("a");
    }

    public static void main(String[] args){
        C3 c3 = new C3();
        c3.i1();
        c3.i2();
        c3.a();
        MultiInterfaces mi = c3;
        mi.a();
        ((C3) mi).i1();
    }
}
