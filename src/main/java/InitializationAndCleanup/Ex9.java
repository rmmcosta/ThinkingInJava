package InitializationAndCleanup;

public class Ex9 {
    public Ex9(){
        System.out.println("default constructor");
    }
    public Ex9(String s){
        this();
        System.out.println("here with "+ s);
    }
    public static void main(String[] args) {
        Ex9 ex9 = new Ex9();
        Ex9 ex91 = new Ex9("Ricardo");
    }
}
