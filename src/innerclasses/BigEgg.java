package innerclasses;

class Egg {
    private Yolk y;
    Egg(){
        System.out.println("Egg");
        y = new Yolk();
    }
    public class Yolk{
        Yolk(){
            System.out.println("Egg-Yolk");
        }
    }
}

public class BigEgg extends Egg{
    public class Yolk{
        Yolk(){
            System.out.println("BigEgg-Yolk");
        }
    }

    public static void main(String[] args){
        BigEgg be = new BigEgg();
    }
}
