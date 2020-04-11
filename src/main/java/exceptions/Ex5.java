package exceptions;

class NoException extends Exception {

}

public class Ex5 {
    public static void main(String[] args) {
        int[] ints = {5, 3, 4, 10};
        printLastElem(ints,7);
    }

    private static void printLastElem(int[] ints, int lastPosition) {
        Exception exception = new ArrayIndexOutOfBoundsException();
        while (exception.getClass() == ArrayIndexOutOfBoundsException.class) {
            try {
                System.out.println(ints[lastPosition]);
                exception = new NoException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                lastPosition--;
                exception = e;
            }
        }
    }
}
