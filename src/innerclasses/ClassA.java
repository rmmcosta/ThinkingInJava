package innerclasses;

public class ClassA {
    public InterfaceU makeU(){
        return new InterfaceU() {
            @Override
            public void method1() {
                System.out.println("Method 1 inside A ");
            }

            @Override
            public void method2() {
                System.out.println("Method 2 inside A ");
            }

            @Override
            public void method3() {
                System.out.println("Method 3 inside A ");
            }
        };
    }
}
