package innerclasses;

class Egg2 {
    private Yolk y;
    Egg2(){
        System.out.println("Egg2");
        y = new Yolk();
    }
    public class Yolk{
        Yolk(){
            System.out.println("Egg2-Yolk");
        }
        public void f(){
            System.out.println("Egg2-Yolk-f()");
        }
    }
    public void insertYolk(Yolk theY){
        y = theY;
    }
    public void g(){
        y.f();
    }
}

public class BigEgg2 extends Egg2{
    public class Yolk extends Egg2.Yolk{
        Yolk(){
            System.out.println("BigEgg2-Yolk");
        }
        public void f(){
            System.out.println("BigEgg2-Yolk-f()");
        }
    }
    BigEgg2(){
        insertYolk(new Yolk());
    }

    public static void main(String[] args){
        Egg2 e2 = new BigEgg2();
        System.out.println(".----------------------------.");
        e2.g();
    }
}
