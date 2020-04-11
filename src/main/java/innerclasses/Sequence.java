package innerclasses;

import java.util.Scanner;

interface Selector{
    boolean hasNext();
    Object current();
    void next();
}
public class Sequence {
    private Object[] objects;
    private int count = 0;

    public Sequence(int size){
        objects = new Object[size];
    }

    public void addInt(int i) {
        if(count==objects.length-1){
            objects[count] = i;
            count = 0;
            return;
        }
        objects[count++] = i;
    }

    public void addText(String s) {
        if(count==objects.length-1){
            objects[count] = s;
            count = 0;
            return;
        }
        objects[count++] = s;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean hasNext() {
            if(i>objects.length-1) {
                i = 0;
                return false;
            }
            return true;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if(i>objects.length-1) {
                i = 0;
            }
            ++i;
        }
    }

    public Selector getSelector(){
        return new SequenceSelector();
    }

    private class ReverseSelector implements Selector {
        private final int initial = objects.length-1;
        private int i = initial;
        @Override
        public boolean hasNext() {
            if(i<0) {
                i = initial;
                return false;
            }
            return true;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if(i<0) {
                i = initial;
            }
            --i;
        }
    }

    public Selector getReverseSelector(){
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence seq = new Sequence(10);
        Selector select = seq.getSelector();
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<10;i++) {
            seq.addInt(sc.nextInt());
        }
        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }

        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }

        select = seq.getReverseSelector();

        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }

        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }

        for(int i = 0;i<10;i++) {
            seq.addText(sc.next());
        }
        select = seq.getSelector();
        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }
        select = seq.getReverseSelector();
        while(select.hasNext()){
            System.out.println(select.current());
            select.next();
        }
    }
}
