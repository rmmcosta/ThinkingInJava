package innerclasses;

public class ClassConstructor {
    private int x;
    public ClassConstructor(){
        x=5;
    }
    public ClassConstructor(int i) {
        x=i;
    }

    public static void main(String[] args) {
        Antoher a = new Antoher();
        System.out.println((a.makeClassConstruct()).x);

        System.out.println((a.makeClassConstruct2(33)).x);
    }
}

class Antoher {
    public ClassConstructor makeClassConstruct(){
        return new ClassConstructor(){

        };
    }

    public ClassConstructor makeClassConstruct2(int y){
        return new ClassConstructor(y){

        };
    }
}
