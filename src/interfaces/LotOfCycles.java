package interfaces;

import interfaces.Cycle;

public class LotOfCycles {
    public static void factoryConsumer(CycleFactory f){
        Cycle c = f.make();
        c.go();
    }

    public static void main(String[] args) {
        factoryConsumer(new UniFactory());
        factoryConsumer(new BiFactory());
        factoryConsumer(new TriFactory());
    }
}

interface CycleFactory{
    Cycle make();
}

class UniFactory implements CycleFactory{

    @Override
    public Cycle make() {
        return new Unicycle();
    }
}

class BiFactory implements CycleFactory{

    @Override
    public Cycle make() {
        return new Bicycle();
    }
}

class TriFactory implements CycleFactory{

    @Override
    public Cycle make() {
        return new Tricycle();
    }
}

class Unicycle implements Cycle{

    @Override
    public void go() {
        System.out.println("Go uni");
    }
}

class Bicycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Go bi");
    }
}

class Tricycle implements Cycle {

    @Override
    public void go() {
        System.out.println("Go Tri");
    }
}