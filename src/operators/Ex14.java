package operators;

public class Ex14 {
    private static void doCompare(String s1, String s2){
        System.out.println("== ->" + (s1==s2));
        System.out.println("!= ->" + (s1 != s2));
        System.out.println("equals() -> " + s1.equals(s2));
    }

    public static void main(String[] args) {
        doCompare("coiso","tal");
        doCompare("cenas", "cenas");
        doCompare("Ana", "Ricardo");
        String s = new String("Hello");
        doCompare(s,"Hello");
    }
}
