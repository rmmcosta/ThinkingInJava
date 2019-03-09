package test;

import reusingclasses.Ex15;

class DerivedProtected extends Ex15 {
    public void derivedSetS(String s) {
        super.setS(s);
    }
}

public class TestEx15Protected {
    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        //ex15.setS("coiso");
        DerivedProtected dp = new DerivedProtected();
        //dp.setS("coiso);
        dp.derivedSetS("coiso");
    }
}
