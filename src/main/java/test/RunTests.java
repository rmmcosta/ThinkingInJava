package test;

import AccessControl.Ex1;
import ControllingExecution.*;
import everythingisanobject.*;

public class RunTests {
    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        ex1.print();
        ex1.initialize();
        ex1.print();
        new ControllingExecution.Ex2();
        //Ex8 ex8 = new Ex8();
    }
}
