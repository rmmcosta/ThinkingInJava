package interfaces;

import java.util.Random;

public class TossingFramework {
    public static void tryLuck(TossingObjectFactory tof) {
        TossingObject to = tof.make();
        to.toss();
    }

    public static void main(String[] args) {
        tryLuck(new DiceFactory());
        tryLuck(new DiceFactory());
        tryLuck(new CoinFactory());
    }
}

interface TossingObject {
    void toss();
}

interface TossingObjectFactory{
    TossingObject make();
}

class Coin implements TossingObject{
    String[] CoinOptions = {"Heads","Tails"};
    @Override
    public void toss() {
        Random r = new Random();
        System.out.println(CoinOptions[r.nextInt(1)]);
    }
}

class Dice implements TossingObject{

    @Override
    public void toss() {
        Random r = new Random();
        System.out.println(r.nextInt(5)+1);
    }
}

class CoinFactory implements TossingObjectFactory{

    @Override
    public TossingObject make() {
        return new Coin();
    }
}


class DiceFactory implements TossingObjectFactory{

    @Override
    public TossingObject make() {
        return new Dice();
    }
}