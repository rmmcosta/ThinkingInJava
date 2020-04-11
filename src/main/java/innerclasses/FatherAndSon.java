package innerclasses;


class Father {
    FatherInner fi;
    Father(){
        System.out.println("In the Father");
        fi = new FatherInner();
    }
    class FatherInner{
        FatherInner(){
            System.out.println("In the FatherInner");
        }

        public void f(){
            System.out.println("FAtherInner f()");
        }
    }

    public void insertFatherInner(FatherInner fatherInner){
        fi = fatherInner;
    }

    public void g(){
        fi.f();
    }
}

public class FatherAndSon extends Father{
    FatherAndSon(){
        System.out.println("In the FatherAndSon");
    }

    class FatherAndSonInner extends FatherInner{
        FatherAndSonInner(){
            System.out.println("In the FatherAndSonInner");
        }
        public void f(){
            System.out.println("FatherAndSonInner f()");
        }
    }

    public static void main(String[] args){
        FatherAndSon fas = new FatherAndSon();
        FatherAndSonInner fasi = fas.new FatherAndSonInner();
        fasi.f();
        fas.g();
        fas.insertFatherInner(fasi);
        fas.g();
    }
}
