package polymorphism;

enum AlertStatus {HIGH, MEDIUM, LOW}

class Motor {
    private boolean isRunning=false;
    private String id;
    Motor(String s) {
        id = s;
    }
    public void start() {
        isRunning = true;
    }
    public void stop() {
        isRunning = false;
    }
    public void printStatus() {
        System.out.println("The motor " + id + ((isRunning)?" Stopped":" Working"));
    }
    @Override
    public String toString(){
        return id;
    }
}

class Jato extends Motor {
    Jato(String s){
        super("Jato " + s);
    }
}

class Starship {
    private AlertStatus as;
    private Motor motor;

    Starship(Motor m) {
        motor = m;
        as = AlertStatus.LOW;
    }

    Starship(AlertStatus alertStatus, Motor m) {
        as = alertStatus;
        motor = m;
    }

    public void changeMotor(Motor m) {
        motor = m;
    }

    public void increaseAlert() {
        System.out.println("Increasing alert...");
        switch (as) {
            default:
            case HIGH:
                break;
            case LOW:
                as = AlertStatus.MEDIUM;
                break;
            case MEDIUM:
                as = AlertStatus.HIGH;
                break;
        }
    }

    public void decreaseAlert() {
        System.out.println("Decreasing alert...");
        switch (as) {
            default:
            case LOW:
                break;
            case HIGH:
                as = AlertStatus.MEDIUM;
                break;
            case MEDIUM:
                as = AlertStatus.LOW;
                break;
        }
    }

    @Override
    public String toString() {
        return "This ship is in an Alert state of " + as.toString() + " working with the motor " + motor;
    }
}

public class Ex16 {
    public static void main(String[] args) {
        Motor m1 = new Motor("MOtor 1");
        Motor m2 = new Motor("Motor 2");
        Jato j1 = new Jato("xpto");
        Starship s = new Starship(m1);
        System.out.println(s);
        s.increaseAlert();
        System.out.println(s);
        s.increaseAlert();
        System.out.println(s);
        s.increaseAlert();
        System.out.println(s);
        s.changeMotor(m2);
        s.decreaseAlert();
        System.out.println(s);
        s.decreaseAlert();
        System.out.println(s);
        s.decreaseAlert();
        System.out.println(s);
        s.decreaseAlert();
        s.changeMotor(j1);
        System.out.println(s);
        s.decreaseAlert();
        System.out.println(s);
        Starship s2 = new Starship(AlertStatus.HIGH, new Motor("Motor 3"));
        System.out.println(s2);
    }
}
