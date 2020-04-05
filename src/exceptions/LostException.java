package exceptions;

class NormalException extends Exception {

    public NormalException(String s) {
        super(s);
    }
}



public class LostException {
    private void methodNormal() throws NormalException {
        throw new NormalException("normal exception!");
    }
    private void methodImportant() throws ImportantException {
        throw new ImportantException("important exception!");
    }

    private class ImportantException extends Throwable {
        public ImportantException(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {

        try {
            LostException lostException = new LostException();
            try {
                lostException.methodImportant();
            } finally {
                //this way, only the normal exception will be presented
                lostException.methodNormal();
                /*try {
                    lostException.methodNormal();
                } catch(Exception e) {
                    e.printStackTrace();
                }*/
            }
        } catch (Exception | ImportantException e) {
            e.printStackTrace();
        }
    }
}
