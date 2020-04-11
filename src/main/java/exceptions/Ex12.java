package exceptions;

class OutOfSpace extends Exception {

    public OutOfSpace(String s) {
        super(s);
    }
}

interface Selector {
    boolean hasNext();
    Object next();
}

public class Ex12 {
    Object[] myObjects;
    int count = 0;

    public Ex12(int numObjects) {
        myObjects = new Object[numObjects];
    }

    private void addString(String s) throws OutOfSpace {
        addObject(s);
    }

    private void addInt(int num) throws OutOfSpace {
        addObject(num);
    }

    private void addObject(Object obj) throws OutOfSpace {
        if (count < myObjects.length) {
            myObjects[count++] = obj;
        } else {
            throw new OutOfSpace("no more space to store objects");
        }
    }

    private Selector getSelector() {
        return new Selector() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return pos<myObjects.length;
            }

            @Override
            public Object next() {
                return myObjects[pos++];
            }
        };
    }

    public static void main(String[] args) {
        Ex12 ex12 = new Ex12(3);
        try {
            ex12.addInt(1);
            ex12.addString("coiso");
            Selector selector = ex12.getSelector();
            while (selector.hasNext()) {
                System.out.println(selector.next());
            }
            ex12.addString("cenas");
            selector = ex12.getSelector();
            while (selector.hasNext()) {
                System.out.println(selector.next());
            }
            ex12.addInt(2);
        } catch(OutOfSpace e) {
            System.err.println(e);
        }

    }
}
