package InitializationAndCleanup;

public class Ex19 {
    public static void printArr(Object[] arr){
        for(Object o : arr){
            System.out.println(o);
        }
    }
    public static void printArr2(String... arr){
        for(Object o:arr){
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        printArr(new String[]{"ana","Ricardo"});
        printArr2(new String[]{"Rui","Manuel","Joao","André"});
        printArr2("Ana","joão","Manuel");
    }
}
