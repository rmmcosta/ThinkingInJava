package operators;

public class Ex10 {
    public static void main(String[] args) {
        final int x = 0b1010101010;
        final int y = 0b0101010101;

        final int xAndy = x&y;
        final int xOry = x|y;
        final int xXory = x^y;

        System.out.println(Integer.toBinaryString(xAndy));
        System.out.println(Integer.toBinaryString(xOry));
        System.out.println(Integer.toBinaryString(xXory));
    }
}
