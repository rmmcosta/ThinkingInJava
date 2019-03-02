package ControllingExecution;

public class Ex8 {
    public static void main(String[] args) {
        for(int i = 0; i<5;i++){
            switch(i){
                case 1: System.out.println('A');
                //break;
                case 2: System.out.println('B');
                //break;
                case 3: System.out.println('C');
                //break;
                case 4: System.out.println('D');
                //break;
                default: System.out.println("none");
            }
        }
    }
}
