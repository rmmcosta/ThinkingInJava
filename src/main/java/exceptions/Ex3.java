package exceptions;

public class Ex3 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        try {
            System.out.println(ints[0]);
            System.out.println(ints[3]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            MyLogging.log(e, e.getClass().getName());
        }
    }
}
