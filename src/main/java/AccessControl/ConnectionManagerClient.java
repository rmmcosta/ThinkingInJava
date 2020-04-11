package AccessControl;

public class ConnectionManagerClient {
    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager(1);
        Connection c1 = cm.getConnection();
        c1.identify();
        Connection c2 = cm.getConnection();
        if(c2!=null)
            c2.identify();
        else
            System.out.println("The Connection does not exists");
    }
}
