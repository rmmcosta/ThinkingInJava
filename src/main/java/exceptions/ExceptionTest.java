package exceptions;

class MyExceptionTest extends Exception {

    public MyExceptionTest(String message) {
        super(message);
    }
}

public class ExceptionTest {
    public void doThings() throws MyExceptionTest {
         throw new MyExceptionTest("do things exception");
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.doThings();
        } catch (MyExceptionTest myExceptionTest) {
            myExceptionTest.printStackTrace();
        }
    }
}
