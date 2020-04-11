package test;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {
    private static final char[] vowels = {'a','e','i','o','u'};
    private static final char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','y','x','z'};
    private static final char[] upperLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private int _wordsNum;
    private int _count = 0;
    private Random random;

    /**
     * @param wordsNum
     */
    public RandomWords(int wordsNum) {
        random = new Random();
        _wordsNum = wordsNum;
    }

    private int appendChar(CharBuffer charBuffer) {
        int charsNum = random.nextInt(15)+3;
        charBuffer.allocate(charsNum);
        charBuffer.append(upperLetters[random.nextInt(upperLetters.length)]);
        for (int j = 1; j < charsNum; j++) {
            if((j+1)%2==0) {
                //vowel
                charBuffer.append(vowels[random.nextInt(vowels.length)]);
            } else {
                //consonant
                charBuffer.append(consonants[random.nextInt(consonants.length)]);
            }
        }
        charBuffer.append("\n");
        return charsNum;
    }

    @Override
    public int read(@NotNull CharBuffer charBuffer) throws IOException {
        //System.out.println("read:" + _count);
        if(_count < _wordsNum) {
            _count++;
            return appendChar(charBuffer);
        } else {
            _count = 0;
            return -1;
        }
    }

    public static void main(String[] args) {
        RandomWords rw = new RandomWords(50);
        Scanner sc = new Scanner(rw);
        while(sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
