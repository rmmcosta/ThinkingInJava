package AccessControl;

public class CMWithCheckInClient {
    public static void main(String[] args) {
        ConnectionTwo[] connectionTwos = new ConnectionTwo[5];
        for (int i = 0; i < 5; i++) {
            connectionTwos[i] = CMWithCheckIn.getConnection();
            connectionTwos[i].Connect();
        }
        System.out.println(CMWithCheckIn.getConnection());
        CMWithCheckIn.checkIn(connectionTwos[1]);
        CMWithCheckIn.getConnection().Connect();
        System.out.println("I made the checkin but i will keep using the connection");
        connectionTwos[1].Connect();
        System.out.println("I will do the checkin twice");
        CMWithCheckIn.checkIn(connectionTwos[1]);
        CMWithCheckIn.checkIn(connectionTwos[1]);
        for (int i = 0; i < 5; i++) {
            connectionTwos[i] = CMWithCheckIn.getConnection();
            if(connectionTwos[i]!=null)
                connectionTwos[i].Connect();
            else
                System.out.println("The connection is occupied");
        }
    }
}
