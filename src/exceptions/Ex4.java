package exceptions;

class MyException extends Exception {
    private String message;
    public MyException(String message) {
        this.message = message;
    }
    public void displayMessage() {
        System.out.println(message);
    }
}

public class Ex4 {
    public static void main(String[] args) {
        try {
            throw new MyException("coiso e tal...");
        } catch(MyException e) {
            e.displayMessage();
        }
    }
}
