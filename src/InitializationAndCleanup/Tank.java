package InitializationAndCleanup;

public class Tank {
    private boolean isEmpty, isFilled;

    public void setEmpty() {
        isEmpty = true;
        isFilled = false;
    }

    public void serFilled() {
        isFilled = true;
        isEmpty = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if(isEmpty) {
            super.finalize();
            System.out.println("Tank finalized");
        }
        else
            System.out.println("The thank is not empty!");
    }

    public static void main(String[] args) {
        Tank t = new Tank();
        t.setEmpty();
        try{
            t.finalize();
        } catch(Exception e){
            System.out.println(e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        new Tank();
        new Tank().setEmpty();
        Tank t1 = new Tank();
        t1 = null;//forces the garbage collector. otherwise the references are in scope and the gc will not clear them.
        System.gc();
        System.runFinalization();
    }
}
