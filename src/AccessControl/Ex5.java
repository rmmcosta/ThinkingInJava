package AccessControl;

public class Ex5 {
    protected String sProtec = "string protected";
    public String sPublic = "string public";
    private String sPrivate = "string private";
    protected void printProtected(){
        System.out.println("Print Protected");
    }
    public void printPublic(){
        System.out.println("Print Public");
    }
    private void printPrivate(){
        System.out.println("Print Private");
    }
    public static void main(String[] args) {
        Ex5 ex5 = new Ex5();
        ex5.printPrivate();
        System.out.println(ex5.sPrivate);
    }
}
