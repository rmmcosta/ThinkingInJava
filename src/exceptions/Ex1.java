package exceptions;

public class Ex1 {
    public static void main(String[] args) {
        try {
            throw new Exception("My exception!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("I'm in the finally!");
        }
    }
}
