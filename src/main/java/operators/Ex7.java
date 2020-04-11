package operators;

import java.util.Random;

class CoinFlipping {
    String[] coin = {"heads","tails"};
    public void play(){
        Random r = new Random();
        System.out.println(coin[r.nextInt(2)]);
    }
}

public class Ex7 {
    public static void main(String[] args) {
        CoinFlipping coinFlipping = new CoinFlipping();
        coinFlipping.play();
        coinFlipping.play();
        coinFlipping.play();
        coinFlipping.play();
    }
}
