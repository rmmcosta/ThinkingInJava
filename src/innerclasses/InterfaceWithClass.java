package innerclasses;

public interface InterfaceWithClass {
    int method();
    //a class inside here is always public and static
    class InterfNestedClass {
        static int x = 3;
        public static void show(InterfaceWithClass i){
            System.out.println(x);
            System.out.println(i.method());
        }

        public void here(){
            System.out.println("Where?");
        }
    }
}
