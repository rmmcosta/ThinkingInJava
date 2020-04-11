package exceptions;

public class LostException2 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            //with this return the exception will be silenced out
            return;
        }
    }
}
