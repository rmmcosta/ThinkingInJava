package holdingYourObjects;

public class Ex15 {
    public static void main(String[] args) {
        Stack<Character> sts = new Stack<Character>();
        String text = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";
        char[] chars = text.toCharArray();
        System.out.println(chars);
        System.out.println(chars.length);
        /*for (char c:chars
             ) {
            System.out.println(c);
        }*/
        for(int i=0;i<chars.length;i++) {
            if(chars[i]=='+') {
                char pushChar = chars[i+1];
                sts.push(pushChar);
                //System.out.println("pushed char:" + pushChar);
            }
            if(chars[i]=='-') {
                System.out.print(sts.pop());
            }
        }
    }
}
