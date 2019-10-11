package holdingYourObjects.PublicPolymorphism;

public class Cheese {
    private static int refCount = 0;

    public Cheese() {
        refCount++;
        System.out.println("I am the cheese. Come bit me!");
    }

    public static void status() {
        System.out.println(refCount + " Cheese Objects beeing used!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cheese finalized!");
    }

    public void dispose() throws Throwable {
        if (--refCount == 0) {
            finalize();
        } else {
            System.out.println("Cheese objects are still being used!");
        }
    }
}


