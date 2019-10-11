package reusingclasses;

class TheObject {

}

class AnObject {
    final String theThing;
    final TheObject to;
    AnObject(){
        theThing = "exactly";
        to = new TheObject();
    }
    AnObject(String s){
        theThing = s;
        to = new TheObject();
    }

    public void changeTO(){
        //cannot assign a value to final variable to
        //to = new TheObject();
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
