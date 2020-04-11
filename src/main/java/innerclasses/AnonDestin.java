package innerclasses;

public class AnonDestin {
    String s = "Coiso";
    public Destination getDestin(String l, float price){
        return new Destination(){
            private int cost;
            //instance initialization it's the constructor for the anonymous inner class
            {
                cost = Math.round(price);
                if(cost>100){
                    System.out.println("Above Budget");
                }
            }
            private String x = s;
            public void echo(){
                System.out.println(l);
                System.out.println(x);
                System.out.println("Cost:"+cost);
            }
        };
    }

    public static void main(String[] args) {
        Destination d = new Destination();
        d.echo();
        AnonDestin ad = new AnonDestin();
        (ad.getDestin("Lav",240.78f)).echo();
    }
}
