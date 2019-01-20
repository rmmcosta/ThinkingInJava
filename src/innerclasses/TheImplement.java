package innerclasses;

public class TheImplement {
    public TheInterface getInterface(){
        class Impl implements TheInterface{
            @Override
            public void show() {
                System.out.println("The show");
            }
        }
        return new Impl();
    }

    private class Inner implements TheInterface {
        int x;
        @Override
        public void show() {
            System.out.println("The show inside Inner");
        }
        public TheImplement getTheImp(){
            return TheImplement.this;
        }
        public class InnerInner {
            public void who(){
                System.out.println("Me");
            }
        }
    }
    // a static inner class is called nested class
    private static class InnerStatic implements TheInterface {
        static int x=3;
        @Override
        public void show() {
            System.out.println(x);
        }
        public static void showStatic(){
            System.out.println(x);
        }
        public static class InnerInnerStatic {
            public static void whoStatic(){
                System.out.println("Me static");
            }
        }
    }

    public TheInterface getPrivate(){
        return new Inner();
    }

    public TheInterface get2(boolean b){
        TheInterface t;
        if(b) {
            class Impl implements TheInterface {

                @Override
                public void show() {
                    System.out.println("Show 2");
                }
            }
            t = new Impl();
        } else {
            t = getInterface();
        }
        return t;
    }

    public static void main(String[] args){
        TheImplement t = new TheImplement();
        t.getInterface().show();
        t.get2(true).show();
        t.get2(false).show();
        t.getPrivate().show();
        ((Inner)t.getPrivate()).show();
        ((t.new Inner()).new InnerInner()).who();
        InnerStatic.showStatic();
        InnerStatic.x = 33;
        InnerStatic.showStatic();
        InnerStatic.InnerInnerStatic.whoStatic();
        //InnerStatic.show(); This does not work because you can't access a non-static method in
        //static way
    }
}
