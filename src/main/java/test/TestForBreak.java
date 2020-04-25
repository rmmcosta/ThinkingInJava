package test;

public class TestForBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                if (i % 2 == 0) {
                    break;
                }
                System.out.println("    "+j);
            }
            System.out.println(i);
        }
    }
}
