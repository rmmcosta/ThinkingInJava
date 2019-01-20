package innerclasses;

public class AnonWraping {
    public Wrapping getWrapping(int x){
        return new Wrapping(x){
            public int getValue(){
                return super.getValue()*47;
            }
        };
    }

    public static void main(String[] args) {
        Wrapping w = new Wrapping(5);
        System.out.println(w.getValue());
        AnonWraping a = new AnonWraping();
        System.out.println((a.getWrapping(5)).getValue());

    }
}
