package privatepack;

public class PrivateClass {
    private int x = 2;
    private void thePrivate(){
        System.out.println("The private:" + x);
    }

    class InnerClass {
        private void modify(){
            x = 10;
            thePrivate();
        }
    }

    public void show(){
        InnerClass i = new InnerClass();
        i.modify();
    }

    public static void main(String[] args) {
        PrivateClass p = new PrivateClass();
        p.thePrivate();
        p.show();
    }
}
