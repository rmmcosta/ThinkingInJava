package exceptions;

class MyExceptionLogging1 extends Exception {

    public MyExceptionLogging1() {
        MyLogging.log(this, MyExceptionLogging1.class.getName());
    }

    public MyExceptionLogging1(String message) {
        super(message);
        MyLogging.log(this, MyExceptionLogging1.class.getName());
    }
}

class MyExceptionLogging2 extends Exception {
    public MyExceptionLogging2() {
        MyLogging.log(this, MyExceptionLogging2.class.getName());
    }
}

public class Ex6 {
    public static void main(String[] args) {
        try {
            throw new MyExceptionLogging1("Cenas!");
        } catch(MyExceptionLogging1 e) {
            System.err.println(e+"\n\n");
        }
        try {
            throw new MyExceptionLogging1();
        } catch(MyExceptionLogging1 e) {
            System.err.println(e+"\n\n");
        }
        try {
            throw new MyExceptionLogging2();
        } catch(Exception e) {
            System.err.println(e+"\n\n");
        }
    }
}
