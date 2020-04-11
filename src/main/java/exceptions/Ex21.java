package exceptions;

class Base {
    public Base() throws CustomerException {
        throw new CustomerException();
    }

    protected class CustomerException extends Throwable {
    }
}

class Derived extends Base {
    public Derived() throws CustomerException {

    }
}



public class Ex21 {
}
