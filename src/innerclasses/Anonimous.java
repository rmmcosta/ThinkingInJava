package innerclasses;

public class Anonimous {
    public Anon getAnon(){
        return new Anon() {
            private int x=5;
            public void echo(){
                System.out.println(x);
            }
        };
    }
    public static void main(String[] args) {
        Anonimous a = new Anonimous();
        (a.getAnon()).echo();
    }
}
