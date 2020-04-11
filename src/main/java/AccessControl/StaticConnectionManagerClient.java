package AccessControl;

public class StaticConnectionManagerClient {
    public static void main(String[] args) {
        AnotherConnection ac;
        while(true){
            ac = StaticConnectionManager.getConnection();
            if(ac!=null)
                ac.presentConnection();
            else
                break;
        }
        System.out.println("No more connetions");
    }
}
