package ControllingExecution;

public class Ex5 {

    public static void printBinaryString(int n){
        char[] buffer = new char[32];
        int position = buffer.length;
        do{
            buffer[--position] = ((n&0b1)==0)?'0':'1';
            n>>>=1;
        }while(n>0);
        for (char c: buffer
             ) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int x = 0b1010101010;
        final int y = 0b0101010101;

        final int xAndy = x&y;
        final int xOry = x|y;
        final int xXory = x^y;
        printBinaryString(x);
        System.out.println(xAndy);
        printBinaryString(xAndy);
        System.out.println(xOry);
        printBinaryString(xOry);
        System.out.println(xXory);
        printBinaryString(xXory);
    }
}
