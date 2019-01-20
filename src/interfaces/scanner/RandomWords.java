package interfaces.scanner;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {
    final String UPLETTERS = "BCDFGHJKLMNPQRSTVWXYZ";
    final char[] UPLARR = UPLETTERS.toCharArray();
    final char[] DOWNLARR = UPLETTERS.toLowerCase().toCharArray();
    final String VOWELS = "aeiou";
    final char[] VARR = VOWELS.toCharArray();
    static Random rand = new Random();
    private int count;

    public RandomWords(int c) {
        count = c;
    }

    @Override
    public int read(CharBuffer cb) {
        if(count-- == 0) {
            return -1;
        }
        cb.append(UPLARR[rand.nextInt(UPLARR.length-1)]);
        for(int i = 0; i < 4; i++){
            cb.append(VARR[rand.nextInt(VARR.length-1)]);
            cb.append(DOWNLARR[rand.nextInt(DOWNLARR.length-1)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(new RandomWords(5));
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}
