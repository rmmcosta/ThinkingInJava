package AccessControl;

class AnotherConnection {
    AnotherConnection() {

    }

    public void presentConnection() {
        System.out.println("I am the " + this.toString());
    }
}

public class StaticConnectionManager {
    private static AnotherConnection[] connections = new AnotherConnection[5];
    private static int conNumber = connections.length - 1;

    static {
        for (int i = 0; i < connections.length; i++) {
            connections[i] = new AnotherConnection();
        }
    }

    public static AnotherConnection getConnection() {
        if (conNumber >= 0) {
            return connections[conNumber--];
        } else {
            return null;
        }
    }
}
