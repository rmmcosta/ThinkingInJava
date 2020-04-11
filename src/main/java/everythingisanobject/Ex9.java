package everythingisanobject;

/**
 * @author Ricardo costa
 * @version 1.0
 */
public class Ex9 {
    /**
     * receive an int return the value added with 10
     * @param i
     * @return
     */
    /**
     * <pre>
     * System.out.println(new Date());
     * </pre>
     */
    public int changeInt(int i){
        return i+10;
    }

    /**
     * receives an integer object and ads 10
     * @param integer
     */
    public void changeInteger(Integer integer) {
        integer+=10;
    }

    /**
     * main method
     * @param args
     *
     */
    public static void main(String[] args) {
        /**
         * creates ex9 object
         */
        Ex9 ex9 = new Ex9();
        int i = 5;
        /**
         * prints cenas
         */
        System.out.println("i="+i+",return="+ex9.changeInt(i));
        Integer integer = i;
        System.out.print("integer="+integer);
        ex9.changeInteger(integer);
        System.out.print(",return="+integer.longValue());
    }
}
