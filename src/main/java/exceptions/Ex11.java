package exceptions;

class Ex11Exception extends Exception {

}


public class Ex11 {
    private void f() throws Ex11Exception {
        throw new Ex11Exception();
    }
    private void g() {
        try {
            f();
        } catch (Ex11Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        ex11.g();
    }
}
