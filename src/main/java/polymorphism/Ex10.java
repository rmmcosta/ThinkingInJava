package polymorphism;

class Car {
    public void openDoor() {
        System.out.println("Opening the door");
    }
    public void startEngine() {
        System.out.println("Starting the engine");
    }
    public void drive() {
        System.out.println("I will start my drive");
        openDoor();
        startEngine();
    }
}

class VW extends Car{
    @Override
    public void startEngine() {
        System.out.println("Oh no there is no engine!");
    }
}

public class Ex10 {
    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
        Car c1 = new VW();
        c1.drive();
    }
}
