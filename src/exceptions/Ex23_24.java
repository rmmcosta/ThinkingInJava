package exceptions;

class FailingConstructor2 {
    private DisposeObject disposeObject, disposeObject2;
    public FailingConstructor2(boolean fail) throws FCException {
        disposeObject = new DisposeObject(1);
        try {
            if (fail) {
                throw new FCException("failing constructor exception!");
            }
        } catch (FCException e) {
            disposeObject.dispose();
            throw e;
        }
        disposeObject2 = new DisposeObject(2);
    }

    protected class FCException extends Throwable {
        public FCException(String s) {
            super(s);
        }
    }

    public void dispose() {
        disposeObject.dispose();
        disposeObject2.dispose();
    }
}

class DisposeObject {
    private final int id;
    public DisposeObject(int id) {
        this.id = id;
    }

    public void dispose() {
        System.out.println("disposing object: " + id);
    }
}

public class Ex23_24 {
    public static void main(String[] args) {
        for (boolean b = false; ; b = !b) {
            try {
                System.out.println("constructing...");
                FailingConstructor2 fc2 = new FailingConstructor2(b);
                try {
                    System.out.println("processing...");
                } finally {
                    System.out.println("cleaning up...");
                    fc2.dispose();
                }
            } catch (FailingConstructor2.FCException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
