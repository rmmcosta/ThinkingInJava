package innerclasses;

public class ThePrivate {
    public static void main(String[] args) {
        TheImplement t = new TheImplement();
        t.getPrivate().show();
        //((TheImplement.Inner)t.getPrivate()).show();
    }
}
