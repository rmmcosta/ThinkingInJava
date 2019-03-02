package AccessControl;

class ConnectionTwo {
    private ConnectionTwo() {

    }

    static ConnectionTwo getConnection() {
        return new ConnectionTwo();
    }

    public void Connect() {
        System.out.println("Establishing connection " + this.toString());
    }
}

public class CMWithCheckIn {
    private static ConnectionTwo[] connections = new ConnectionTwo[5];
    private static int currentConnection = connections.length-1;

    static {
        for (int i = 0; i < connections.length; i++) {
            connections[i] = ConnectionTwo.getConnection();
        }
    }
    public static ConnectionTwo getConnection(){
        if(currentConnection>=0){
            ConnectionTwo temp = connections[currentConnection];
            connections[currentConnection--] = null;
            return temp;
        } else {
            return null;
        }
    }
    public static void checkIn(ConnectionTwo c){
          connections[++currentConnection] = c;
    }
}
