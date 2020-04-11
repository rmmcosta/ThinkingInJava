package innerclasses;

public class StringClass {
    String text;
    public StringClass(String s){
        text = s;
    }
    @Override
    public String toString(){
        return "The "+text;
    }
}
