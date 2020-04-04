package exceptions;

public class ExceptionTestSample {
    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.doThings();
        } catch (MyExceptionTest myExceptionTest) {
            System.out.println(myExceptionTest.getMessage());
        }
    }
}
