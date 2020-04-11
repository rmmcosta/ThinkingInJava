package InitializationAndCleanup;

import static InitializationAndCleanup.Ex20Enum.EuroCurrency;

public class Ex21 {
    public static void main(String[] args) {
        EuroCurrency ec = EuroCurrency.FIFTY;
        switch (ec){
            case FIVE: System.out.println("the five"); break;
            case FIFTY: System.out.println("the fifty");break;
            default: System.out.println("default");
        }
    }
}
