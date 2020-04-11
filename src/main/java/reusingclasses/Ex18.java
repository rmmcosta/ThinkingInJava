package reusingclasses;

class TestFinal {
    //static final is mandatory to be defined
    public static final int theNumber=19;
    //only final the assignment can be delayed but we can assign only once
    private final int theSecond;
    TestFinal(int i){
        theSecond = i;
    }
    TestFinal() {theSecond = 33;} // this ensures that theSecond is never empty
    public void setTheSecond(int i){
        // this will not work
        //theSecond = i;
    }
    public int getTheSecond(){
        //the second can be empty and so this genereates a compile error
        return theSecond;
        //return 3;
    }
}


public class Ex18 {
    public static void main(String[] args) {
        TestFinal tf = new TestFinal(10);
        System.out.println(tf.getTheSecond());
        System.out.println(TestFinal.theNumber);

        TestFinal tf2 = new TestFinal(44);
        System.out.println(tf2.getTheSecond());
        System.out.println(TestFinal.theNumber);

        TestFinal tf3 = new TestFinal();
        System.out.println(tf3.getTheSecond());
        System.out.println(TestFinal.theNumber);
    }
}
