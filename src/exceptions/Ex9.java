package exceptions;

class XptoException extends Exception {

}

class ZptyException extends Exception {

}

class XptzException extends Exception {

}

public class Ex9 {
    private void throwsAll(int num) throws XptoException, ZptyException, XptzException {
        switch (num) {
            case 0:
                throw new XptoException();
            case 1:
                throw new ZptyException();
            case 2:
                throw new XptzException();
        }
    }

    public static void main(String[] args) {
        Ex9 ex9 = new Ex9();
        try {
            ex9.throwsAll(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
