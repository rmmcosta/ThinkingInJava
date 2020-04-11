package exceptions;

interface Ex8Things {
    public void doThings() throws MyException;
}

public class Ex8 implements Ex8Things {
    public static void main(String[] args) {
        Ex8 ex8 = new Ex8();
        try {
            ex8.doThings();
        } catch (MyException e) {
            System.err.println("in the catch.");
            e.printStackTrace();
        }
    }
    @Override
    public void doThings() throws MyException {
        System.out.println("doing things...");
        throw new MyException("exception doing things...");
    }
}
