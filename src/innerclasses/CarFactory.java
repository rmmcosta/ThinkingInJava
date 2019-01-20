package innerclasses;

interface Car {
    void showColor();
}

interface CarMaker {
    Car makeCar();
}

class BlueCars implements Car{
    public void showColor() {
        System.out.println("Blue");
    }
    public static CarMaker cmk = new CarMaker() {
        @Override
        public Car makeCar() {
            return new BlueCars();
        }
    };
}

class RedCars implements Car{
    public void showColor() {
        System.out.println("Red");
    }
    public static CarMaker cmk = new CarMaker() {
        @Override
        public Car makeCar() {
            return new RedCars();
        }
    };
}

public class CarFactory {
    public static void consumer(CarMaker cm) {
        Car c = cm.makeCar();
        c.showColor();
    }
    public static void main(String[] args) {
        consumer(RedCars.cmk);
        consumer(BlueCars.cmk);
        consumer(BlueCars.cmk);
        consumer(RedCars.cmk);
    }

}
