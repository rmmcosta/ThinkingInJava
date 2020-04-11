package InitializationAndCleanup;

public class Ex17 {
    Ex17(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        Ex17[] arrs = new Ex17[5];
        Ex17[] arrs2 = {new Ex17("Ana"),new Ex17("Ricardo")};
        Ex17[] arrs3 = new Ex17[7];

        for(int i = 0;i<arrs3.length;i++){
            arrs3[i] = new Ex17(i+"");
        }
    }
}
