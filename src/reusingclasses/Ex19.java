package reusingclasses;

class AnObject {
    final String theThing;
    AnObject(){
        theThing = "exactly";
    }
    AnObject(String s){
        theThing = s;
    }
    @Override
    public String toString(){
        return theThing;
    }
}

public class Ex19 {
    public static void main(String[] args) {
     AnObject ao = new AnObject();
     AnObject ao2 = new AnObject("Allien");
     System.out.println(ao);
     System.out.println(ao2);
    }
}
