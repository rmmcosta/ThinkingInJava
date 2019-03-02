package AccessControl;


class Connection {
    private Connection() {

    }

    static Connection establishConnection(){
        return new Connection();
    }

    public void identify(){
        System.out.println("I am the :" + this.getClass().getSimpleName() + " "+ this.toString());
    }

}

public class ConnectionManager {
    private Connection[] connections;
    private int connectionNumber;

    public ConnectionManager(int numOfConnections) {
        connections = new Connection[numOfConnections];
        connectionNumber = numOfConnections - 1;
        fillConnections();
    }

    public Connection getConnection() {
        if (connectionNumber >= 0) {
            return connections[connectionNumber--];
        } else {
            return null;
        }
    }

    private void fillConnections(){
        for(int i = 0;i<connections.length;i++){
            connections[i] = Connection.establishConnection();
        }
    }
}
