package innerclasses;

public class LotOfCycles {
    public static void factoryConsumer(CycleFactory f){
        Cycle c = f.make();
        c.go();
    }

    public static void main(String[] args) {
        factoryConsumer(Unicycle.factory);
        factoryConsumer(Bicycle.factory);
        factoryConsumer(Tricycle.factory);
    }
}

interface CycleFactory{
    Cycle make();
}

class Unicycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Go uni");
    }
    public static CycleFactory factory = new CycleFactory() {

        @Override
        public Cycle make() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Go bi");
    }
    public static CycleFactory factory = new CycleFactory() {

        @Override
        public Cycle make() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Go Tri");
    }
    public static CycleFactory factory = new CycleFactory() {

        @Override
        public Cycle make() {
            return new Tricycle();
        }
    };
}