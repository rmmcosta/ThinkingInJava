package exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FailingConstructor {
    private String theName;

    public FailingConstructor(String theName) throws CustomRuntimeException {
        this.theName = theName;
        Constructors.addFailingConstructor(this);
        throw new CustomRuntimeException("custom runtime exception");
    }

    public String getTheName() {
        return theName;
    }

    class CustomRuntimeException extends Throwable {
        public CustomRuntimeException(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        return theName;
    }
}

class Constructors {
    static List<FailingConstructor> failingConstructors = new ArrayList<>();

    static void addFailingConstructor(FailingConstructor failingConstructor) {
        failingConstructors.add(failingConstructor);
    }

    static void printFailingConstructors() {
        System.out.println("printing constructors...");
        System.out.println(failingConstructors);
    }

    static void removeFailingConstructor(String name) {
        Iterator<FailingConstructor> iterator = failingConstructors.iterator();
        while (iterator.hasNext()) {
            FailingConstructor fc = iterator.next();
            if (fc.getTheName() == name) {
                iterator.remove();
            }
        }
    }
}

class BeOrNotToBe {
    public BeOrNotToBe(boolean valid) throws CustomRuntimeException {
        if (!valid) {
            throw new CustomRuntimeException();
        }
    }

    class CustomRuntimeException extends Exception {
    }
}

public class Ex22 {
    public static void main(String[] args) {
        FailingConstructor failingConstructor;
        String NAME = "xpto";
        try {
            failingConstructor = new FailingConstructor("xpto");
        } catch (FailingConstructor.CustomRuntimeException e) {
            e.printStackTrace();
            Constructors.printFailingConstructors();
        } finally {
            //another and more elegant solution is to add a try catch in the constructor
            //surrounding the code that might throw an exception and on that catch remove the
            //failing constructor
            Constructors.removeFailingConstructor(NAME);
        }
        Constructors.printFailingConstructors();
        for (boolean b = true; ; b = !b) {
            try {
                System.out.println("constructing...");
                new BeOrNotToBe(b);
                try {
                    System.out.println("processing...");
                } finally {
                    System.out.println("cleaning up...");
                }
            } catch (BeOrNotToBe.CustomRuntimeException e) {
                e.printStackTrace();
                System.out.println(e);
                break;
            }
        }
    }
}
