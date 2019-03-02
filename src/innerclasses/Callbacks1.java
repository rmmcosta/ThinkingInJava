package innerclasses;

import org.jetbrains.annotations.NotNull;

interface Motor {
    void start();
}

class V6 implements Motor {
    @Override
    public void start() {
        System.out.println("Vum, Vum, Vum, Vum, Vum, Vum");
    }
}

class Bike {
    private int i = 0;
    public void start(){
        System.out.println("Zem");
        System.out.println(++i);
    }
}

class Kawasaki extends Bike{
    class KaMotor implements Motor {

        @Override
        public void start() {
            Kawasaki.this.start();
        }
    }

    public Motor getMotor(){
        return new KaMotor();
    }
}

class StartMotors {
    private Motor m;
    StartMotors(Motor motor){
        m = motor;
    }

    public void go(){
        m.start();
    }

    public static void go(@NotNull Motor motor){
        motor.start();
    }
}

public class Callbacks1 {
    public static void main(String[] args){
        V6 v =new V6();
        Bike b = new Bike();
        v.start();
        b.start();
        Kawasaki k = new Kawasaki();
        k.start();
        k.start();
        StartMotors sm = new StartMotors(v);
        System.out.println(".--------------------.");
        sm.go();
        sm.go(k.getMotor());

    }

}
