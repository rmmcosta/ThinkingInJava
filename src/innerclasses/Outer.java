package innerclasses;

public class Outer {
    private String text;
    public Outer(){
        text = "default";
    }
    public Outer(String s){
        text = s;
    }
    public class Inner {
        public void printcenas() {
            System.out.println("cenas");
        }
        public Outer getOuter() {
            return Outer.this;
        }
        @Override
        public String toString(){
            return text;
        }
    }

    public Inner getInner(){
        return new Inner();
    }
    @Override
    public String toString(){
        return "The Outer";
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        Inner inner = outer.getInner();
        inner.printcenas();
    }
}
