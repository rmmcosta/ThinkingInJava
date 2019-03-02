package innerclasses;

import java.util.Arrays;

public class ClassB {
    private InterfaceU[] us;
    private int count = 0;

    public ClassB(int size){
        us = new InterfaceU[size];
    }

    public void addU(InterfaceU u){
        us[count++] = u;
    }

    public void makeNull(InterfaceU u){
        us[Arrays.asList(us).indexOf(u)] = null;
    }

    public void showUs(){
        for (InterfaceU iu: us) {
            if(iu!=null) {
                iu.method1();
                iu.method2();
                iu.method3();
            }
        }
    }

    public static void main(String[] args) {
        ClassA ca1 = new ClassA();
        ClassA ca2 = new ClassA();
        ClassA ca3 = new ClassA();
        ClassB cb = new ClassB(3);
        InterfaceU iu1 = ca1.makeU();
        InterfaceU iu2 = ca2.makeU();
        InterfaceU iu3 = ca3.makeU();
        cb.addU(iu1);
        cb.addU(iu2);
        cb.addU(iu3);

        cb.showUs();
        cb.makeNull(iu2);
        cb.showUs();
    }
}
