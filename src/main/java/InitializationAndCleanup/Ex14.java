package InitializationAndCleanup;

public class Ex14 {
    static String fName = "Ricarod";
    static String lNmae;
    static {
        lNmae = "Costa";
        System.out.println(fName);
        System.out.println(lNmae);
    }
    public static void main(String[] args) {
        System.out.println(fName);
        System.out.println(lNmae);
    }
}
