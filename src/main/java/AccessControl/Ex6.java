package AccessControl;

class ProtData {
    protected static String s="Ana";
    protected static void printS(){
        System.out.println(s);
    }
    protected int theNumber = 10;
    protected void printN(){
        System.out.println(theNumber);
    }
}

public class Ex6 {
    public static void main(String[] args) {
        ProtData.printS();
        ProtData.s = "Ricardo";
        ProtData.printS();
        ProtData pd = new ProtData();
        pd.printN();
        pd.theNumber = 5;
        pd.printN();
    }
}
