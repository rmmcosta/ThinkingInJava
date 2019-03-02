package ControllingExecution;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex10_VampireNumbers {
    private static void printVampire4(){
        for(int i = 1000;i<9999;i++){
            if(isVampire4(i))
                System.out.println(i);
        }
    }
    private static boolean isVampire4(int i){
        String iString = Integer.toString(i);
        char[] chars = iString.toCharArray();

        if(chars.length!=4){
            System.out.println("Not a four digit number!");
            return false;
        }
        int[] digits = new int[chars.length];
        for(int j=0;j<digits.length;j++){
            digits[j] = Character.getNumericValue(chars[j]);
        }
        //0123 1023
        if((digits[0]*10+digits[1])*(digits[2]*10+digits[3])==i)
            return true;
        if((digits[1]*10+digits[0])*(digits[2]*10+digits[3])==i)
            return true;

        //0132 1032
        if((digits[0]*10+digits[1])*(digits[3]*10+digits[2])==i)
            return true;
        if((digits[1]*10+digits[0])*(digits[3]*10+digits[2])==i)
            return true;

        //2103 2130
        if((digits[2]*10+digits[1])*(digits[0]*10+digits[3])==i)
            return true;
        if((digits[2]*10+digits[1])*(digits[3]*10+digits[0])==i)
            return true;

        //1302 1320
        if((digits[1]*10+digits[3])*(digits[0]*10+digits[2])==i)
            return true;
        if((digits[1]*10+digits[3])*(digits[2]*10+digits[0])==i)
            return true;

        //1203 1230
        if((digits[1]*10+digits[2])*(digits[0]*10+digits[3])==i)
            return true;
        if((digits[1]*10+digits[2])*(digits[3]*10+digits[0])==i)
            return true;

        //3102 3120
        if((digits[3]*10+digits[1])*(digits[0]*10+digits[2])==i)
            return true;
        if((digits[3]*10+digits[1])*(digits[2]*10+digits[0])==i)
            return true;

        return false;
    }
    private static boolean isVampire4v2(int i){
        int[] digits = new int[4];
        digits[0] = i/1000;
        digits[1] = i%1000/100;
        digits[2] = i%1000%100/10;
        digits[3] = i%1000%100%10;
        //0123 1023
        if((digits[0]*10+digits[1])*(digits[2]*10+digits[3])==i)
            return true;
        if((digits[1]*10+digits[0])*(digits[2]*10+digits[3])==i)
            return true;

        //0132 1032
        if((digits[0]*10+digits[1])*(digits[3]*10+digits[2])==i)
            return true;
        if((digits[1]*10+digits[0])*(digits[3]*10+digits[2])==i)
            return true;

        //2103 2130
        if((digits[2]*10+digits[1])*(digits[0]*10+digits[3])==i)
            return true;
        if((digits[2]*10+digits[1])*(digits[3]*10+digits[0])==i)
            return true;

        //1302 1320
        if((digits[1]*10+digits[3])*(digits[0]*10+digits[2])==i)
            return true;
        if((digits[1]*10+digits[3])*(digits[2]*10+digits[0])==i)
            return true;

        //1203 1230
        if((digits[1]*10+digits[2])*(digits[0]*10+digits[3])==i)
            return true;
        if((digits[1]*10+digits[2])*(digits[3]*10+digits[0])==i)
            return true;

        //3102 3120
        if((digits[3]*10+digits[1])*(digits[0]*10+digits[2])==i)
            return true;
        if((digits[3]*10+digits[1])*(digits[2]*10+digits[0])==i)
            return true;

        return false;
    }

    private static void printVampire4v2(){
        int product;
        List<Integer> products = new ArrayList<Integer>();
        for(int i = 10;i<=99;i++){
            for(int j=10;j<=99;j++){
                if((i*j)%9!=(i+j)%9)
                    continue;
                product = i*j;
                if(isVampire4v3(product,i,j)){
                    if(!products.contains(product)){
                        products.add(product);
                        System.out.println(i+"*"+j+"="+product);
                    }
                }
            }
        }
    }

    private static void printVampire4v3(){
        int product;
        List<Integer> products = new ArrayList<Integer>();
        for(int i = 10;i<=99;i++){
            //if we start the j with the value of i we will not print duplicates
            for(int j=i;j<=99;j++){
                if((i*j)%9!=(i+j)%9)
                    continue;
                product = i*j;
                if(isVampire4v3(product,i,j)){
                    if(!products.contains(product)){
                        products.add(product);
                        System.out.println(i+"*"+j+"="+product);
                    }
                }
            }
        }
    }

    private static void printVampire4v2WithDuplicates(){
        int product;
        for(int i = 10;i<=99;i++){
            for(int j=10;j<=99;j++){
                if((i*j)%9!=(i+j)%9)
                    continue;
                product = i*j;
                if(isVampire4v3(product,i,j)){
                    System.out.println(i+"*"+j+"="+product);
                }
            }
        }
    }

    private static boolean isVampire4v3(int product, int i, int j){
        int[] productDigits = new int[4];
        int[] parcelDigits = new int[4];
        productDigits[0] = product/1000;
        productDigits[1] = product%1000/100;
        productDigits[2] = product%1000%100/10;
        productDigits[3] = product%1000%100%10;
        parcelDigits[0] = i/10;
        parcelDigits[1] = i%10;
        parcelDigits[2] = j/10;
        parcelDigits[3] = j%10;
        int count=0;
        for(int a=0;a<4;a++){
            for(int b=0;b<4;b++){
                if(productDigits[a]==parcelDigits[b]) {
                    parcelDigits[b] = -1;
                    count++;
                    break;
                }
            }
        }
        if(count==4)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        printVampire4();
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        printVampire4v2();
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        printVampire4v2WithDuplicates();
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now());
        printVampire4v3();
        System.out.println(LocalDateTime.now());
    }
}
