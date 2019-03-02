package innerclasses;

import java.util.Random;

public class TossingFramework {
    public static void tryLuck(TossingObjectFactory tof) {
        TossingObject to = tof.make();
        to.toss();
    }

    public static void main(String[] args) {
        tryLuck(Coin.factory);
        tryLuck(Dice.factory);
        tryLuck(Coin.factory);
    }
}

interface TossingObject {
    void toss();
}

interface TossingObjectFactory{
    TossingObject make();
}

class Coin implements TossingObject {
    String[] CoinOptions = {"Heads","Tails"};
    @Override
    public void toss() {
        Random r = new Random();
        System.out.println(CoinOptions[r.nextInt(2)]);
    }
    public static TossingObjectFactory factory = new TossingObjectFactory() {
        @Override
        public TossingObject make() {
            return new Coin();
        }
    };
}

class Dice implements TossingObject {

    @Override
    public void toss() {
        Random r = new Random();
        System.out.println(r.nextInt(6)+1);
    }
    public static TossingObjectFactory factory = new TossingObjectFactory() {
        @Override
        public TossingObject make() {
            return new Dice();
        }
    };
}