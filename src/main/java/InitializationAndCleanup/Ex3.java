package InitializationAndCleanup;

public class Ex3 {
    public Ex3(){
        System.out.println("here in the constructor");
    }
    public Ex3(String s){
        System.out.println("here in the constructor with "+s);
    }
    public static void main(String[] args) {
        Ex3 ex3 = new Ex3();
        Ex3 ex31 = new Ex3("Ricardo");
    }
}
