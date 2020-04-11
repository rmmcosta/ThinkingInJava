package exceptions;

import java.util.Arrays;

class MyLastElementException extends Exception {
    public MyLastElementException(String message) {
        super(message);
    }
}

class MyLastElement {
    private int[] ints;
    private int count = 10;

    public MyLastElement(int... ints) {
        //this.ints = new int[ints.length];
        this.ints = Arrays.copyOf(ints, ints.length);
    }

    public void printLastElement() throws MyLastElementException {
        if(count>=0 && count<ints.length) {
            System.out.println(ints[count]);
        } else {
            if(count>=0)
                count--;
            else
                count++;
            throw new MyLastElementException("my last element exception");
        }
    }
}

public class Ex5_v2 {
    public static void main(String[] args) {
        MyLastElement myLastElement = new MyLastElement(1, 2, 3, 4, 5);
        while (true) {
            try {
                myLastElement.printLastElement();
                break;
            } catch (MyLastElementException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}
