package everythingisanobject;

public class Ex8 {
    /**
     * static string primitive type var
     */
    static String s;
    /**
     * You can <em>even</em> insert a list:
     * <ol>
     * <li> Item one
     * <li> Item two
     * <li> Item three
     * </ol>
     */
    Ex8(String s){
        this.s = s;
    }
    public String toString(){
        return s;
    }
    /**
     * You can <em>even</em> insert a list:
     * <ol>
     * <li> Item one
     * <li> Item two
     * <li> Item three
     * </ol>
     */
    public static void main(String[] args) {
        Ex8 ex81 = new Ex8("Ana");
        System.out.println(ex81);
        Ex8 ex82 = new Ex8("Ricardo");
        System.out.println(ex81);
        System.out.println(ex82);
    }

}
