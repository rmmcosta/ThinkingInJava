package classpack;

import interfacepack.MyInterface;

public class ChildClass1 extends MyClass {
    public void test(){
        MyClass m = new MyClass();
        System.out.println(m.z);
        MyInterface in = m.new InnerMyClass();
        ChildClass1 c = new ChildClass1();
        MyInterface in1 = c.new InnerMyClass();
    }
}
