package innerclasses;

public class AnonPrivate {
    private int x=3;
    private void echo(){
        System.out.println(x);
    }
    private abstract class InnerClass {
        abstract void changeEcho();
    }

    public InnerClass getInner(){
        return new InnerClass(){
            public void changeEcho(){
                x = 5;
                echo();
            }
        };
    }

    public InnerClass getInner2(){
        return new InnerClass(){
            public void changeEcho(){
                x = 53;
                echo();
            }
        };
    }

    public static void main(String[] args){
        AnonPrivate a = new AnonPrivate();
        InnerClass i = a.getInner();
        a.echo();
        i.changeEcho();
        (a.getInner2()).changeEcho();
        a.echo();
    }
}
