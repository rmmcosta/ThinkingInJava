package holdingYourObjects;

import java.util.Arrays;
import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> internalList;
    public Stack() {
        internalList = new LinkedList<T>();
    }
    public Stack(LinkedList<T> list){
        internalList = new LinkedList<T>(list);
    }
    public void push(T element) {
        internalList.add(element);
    }
    public T pop() {
        return internalList.removeLast();
    }
    public boolean isEmpty() {
        return internalList.isEmpty();
    }
    @Override
    public String toString() {
        return internalList.toString();
    }

    public static void main(String[] args) {
        Stack<String> sts = new Stack<String>(new LinkedList<String>(Arrays.asList("coisio", "talk")));
        System.out.println(sts);
        sts.push("ai vai");
        sts.push("sem dúvidas");
        System.out.println(sts.pop());
        System.out.println(sts.pop());
        System.out.println(sts.pop());

        Stack<Integer> ints = new Stack<Integer>(new LinkedList<Integer>(Arrays.asList(5, 6)));
        System.out.println(ints);
        ints.push(2);
        ints.push(2);
        System.out.println(ints.pop());
        System.out.println(ints.pop());
        System.out.println(ints.pop());
    }
}
