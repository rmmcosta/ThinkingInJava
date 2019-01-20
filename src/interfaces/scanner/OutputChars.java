package interfaces.scanner;

import java.nio.CharBuffer;
import java.util.Scanner;

public class OutputChars {
    public char outchar() {
        return 'a';
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(new OutAdapter(new OutputChars(),5));
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}

class OutAdapter implements Readable {
    OutputChars oc;
    int count;

    public OutAdapter(OutputChars o, int c){
        oc = o;
        count = c;
    }

    @Override
    public int read(CharBuffer cb) {
        if(count--==0){
            return -1;
        }
        cb.append(oc.outchar());
        cb.append(" ");
        return 2;
    }
}
