package exceptions;

class MyNoneException extends Exception {

    public MyNoneException(String s) {
        super(s);
    }
}

public class Ex13_14_15 {
    static void method1() throws MyNoneException {
        throw new MyNoneException("My none exception!");
    }

    static void close() {
        System.out.println("closing...");
    }

    static void methodRuntime() {
        throw new RuntimeException("method fail in runtime!");
    }
    public static void main(String[] args) {
        try {
            method1();
        } catch (MyNoneException e) {
            System.out.println(e.getMessage());
            close();
        }
        try {
            methodRuntime();
            method1();
        } catch (MyNoneException e) {
            System.out.println(e.getMessage());
            close();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            methodRuntime();
            method1();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        try {
            throw new RuntimeException("just to mess around...");
        } finally {
            close();
        }
    }
}
