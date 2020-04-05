package exceptions;

class ExceptionEx10 extends Exception {

}

class ExceptionEx10_v2 extends Exception {

}

public class Ex10 {
    private void f() throws ExceptionEx10_v2 {
        try {
            g();
        } catch (ExceptionEx10 exceptionEx10) {
            ExceptionEx10_v2 e = new ExceptionEx10_v2();
            e.initCause(exceptionEx10);
            throw e;
        }
    }

    private void g() throws ExceptionEx10{
        throw new ExceptionEx10();
    }

    public static void main(String[] args) {
        Ex10 ex10 = new Ex10();
        try {
            ex10.f();
        } catch (ExceptionEx10_v2 exceptionEx10_v2) {
            exceptionEx10_v2.printStackTrace();
        }
    }
}
