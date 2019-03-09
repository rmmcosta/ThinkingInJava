package reusingclasses;

public class Ex15 {
    private String s;
    protected void setS(String s) {
        this.s = s;
        System.out.println("setted to " + s);
    }
}
