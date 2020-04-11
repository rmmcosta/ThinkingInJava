package InitializationAndCleanup;

public class Ex11 {
    protected void finalize(){
        System.out.println("here in the finalize");
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Ex11();
        System.gc();
        System.runFinalization();
    }
}
