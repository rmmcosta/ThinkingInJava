package everythingisanobject;

/** First program that receives arguments trough main
 *  receives the arguments and displays them
 * @author Ricardo Costa
 * @version 1.0
 */

public class Ex10 {
    /**
     * only main
     * @param args
     */
    public static void main(String[] args) {
        for (String s: args
             ) {
            System.out.println("args:"+s);
        }
    }
}
