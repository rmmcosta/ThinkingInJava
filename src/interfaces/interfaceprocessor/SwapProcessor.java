package interfaces.interfaceprocessor;

public class SwapProcessor implements Processor{
    Swap swap;
    SwapProcessor(Swap s){
        swap = s;
    }
    public String name(){
        return swap.getClass().getSimpleName();
    }
    public String process(Object s) {
        return swap.swapper((String)s);
    }

    public static void main(String[] args){
        String s = "coiso e tal";
        Apply.process(new SwapProcessor(new Swap()),s);
    }
}
