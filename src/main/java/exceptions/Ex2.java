package exceptions;

class MyClass {
    public void go() {

    }
}

public class Ex2 {
    public static void main(String[] args) {
        MyClass myObject = null;
        try {
            myObject.go();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
            System.out.println(e.toString());
        }
    }
}
