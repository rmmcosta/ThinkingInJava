package operators;

public class Ex8 {
    public static void main(String[] args) {
        long hex = 0x4A;
        long oct = 0112;
        int i = 74;
        System.out.println(hex);
        System.out.println(Long.toBinaryString(hex));
        System.out.println(oct);
        System.out.println(Integer.toHexString(i));
        System.out.println(hex==oct);
        System.out.println(oct==i);
    }
}
