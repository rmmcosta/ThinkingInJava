package innerclasses;

class WithInner{
    WithInner(){
        System.out.println("WithInner");
    }
    class Inner{
        private int x;
        Inner(int i){
            x=i;
        }
        public String toString(){
            return "x:"+x;
        }
    }
}

//this won't compile we need to add a constructor to call
// the super constructor
class A extends WithInner.Inner {
    A(WithInner wi){
        wi.super(5);
    }
}

class Beta {
    class Charlie extends WithInner.Inner{
        protected Charlie(WithInner wi){
            wi.super(33);
        }
    }
}

public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi) {
        wi.super(4);
        System.out.println("Inner extends");
    }

    public static void main(String[] args){
        WithInner wi = new WithInner();
        System.out.println(wi.new Inner(6));
        InheritInner ii = new InheritInner(wi);
        System.out.println(ii);
        Beta b = new Beta();
        Beta.Charlie theC = b.new Charlie(wi);
        System.out.println(theC);
    }
}


