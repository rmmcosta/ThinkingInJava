package exceptions;

abstract class Fruit {
    abstract void getColor() throws ColorUnknown;

    protected class ColorUnknown extends Exception {
        public ColorUnknown(String s) {
            super(s);
        }
    }
}

interface Food {
    void getColor() throws ColorDeprecated, Fruit.ColorUnknown;

    class ColorDeprecated extends Exception {
        public ColorDeprecated(String s) {
            super(s);
        }
    }
}

class Peach extends Fruit implements Food {

    @Override
    public void getColor() throws ColorUnknown {
        try {
            throw new ColorDeprecated("color deprecated!");
        } catch (ColorDeprecated colorDeprecated) {
            ColorUnknown e = new ColorUnknown("color unknown!");
            e.initCause(colorDeprecated);
            throw e;
        }
    }
}

class Apple extends Fruit {

    @Override
    void getColor() throws ColorUnknown {
        throw new ColorUnknown("color unknown!");
    }
}

class Banana implements Food {

    @Override
    public void getColor() throws ColorDeprecated, Fruit.ColorUnknown {
        throw new ColorDeprecated("color deprecated!");
    }
}

public class BaseClassExceptions {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Peach peach = new Peach();
        Banana banana = new Banana();
        try {
            //apple.getColor();
            //peach.getColor();
            banana.getColor();
        } catch (Fruit.ColorUnknown colorUnknown) {
            colorUnknown.printStackTrace();
        } catch (Food.ColorDeprecated colorDeprecated) {
            colorDeprecated.printStackTrace();
        }
    }
}
