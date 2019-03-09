package reusingclasses;

//: reusing/Car.java
// Composition with public objects.
class Engine {
    public void start() {System.out.println("starting");}
    public void rev() {System.out.println("reversing");}
    public void stop() {System.out.println("stoping");}
    public void service() {System.out.println("Service needed");}
}
class Wheel {
    public void inflate(int psi) {System.out.println("inflating " + psi);}
}
class Window {
    public void rollup() {System.out.println("Rolling up");}
    public void rolldown() {System.out.println("Rolling down");}
}
class Door {
    public Window window = new Window();
    public void open() {System.out.println("opening window");}
    public void close() {System.out.println("closing window");}
}
public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door(); // 2-door
    public Car() {
        for(int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
} ///:~