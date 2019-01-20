package innerclasses;

import com.sun.istack.internal.Pool;

public class ImplementInterfWithClass implements InterfaceWithClass {
    @Override
    public int method() {
       return 2334;
    }

    public static void main(String[] args){
        ImplementInterfWithClass i = new ImplementInterfWithClass();
        InterfNestedClass.show(i);
        InterfNestedClass n = new InterfNestedClass();
        n.here();
    }
}
