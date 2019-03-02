package innerclasses;

public class MySequence {
    private Object[] objects;
    private int next;
    public MySequence(int size){
        objects = new Object[size];
        next = 0;
    }
    public void add(Object o) {
        objects[next++] = o;
    }
    public void present(){
        for (Object o: objects
             ) {
            System.out.println(o);
        }
    }

    public static void main(String[] args){
        MySequence s = new MySequence(3);
        StringClass sc1 = new StringClass("Coiso");
        s.add(sc1);
        StringClass sc2 = new StringClass("e");
        s.add(sc2);
        StringClass sc3 = new StringClass("tal");
        s.add(sc3);
        s.present();

    }
}
