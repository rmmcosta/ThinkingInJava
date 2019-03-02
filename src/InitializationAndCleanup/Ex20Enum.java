package InitializationAndCleanup;

public class Ex20Enum {
    public enum EuroCurrency{FIVE,TEN,TWENTY,FIFTY}
    public static void main(String[] args) {
        for(EuroCurrency e : EuroCurrency.values()){
            System.out.println(e);
            System.out.println(e.ordinal());
        }
    }
}
