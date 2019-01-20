package interfaces.interfaceprocessor;

public class Swap {
    public String swapper(String s) {
        char[] swapArr = s.toCharArray();
        for(int i = 0;i<swapArr.length-2;i=i+2){
            char temp = swapArr[i];
            swapArr[i]=swapArr[i+1];
            swapArr[i+1] = temp;
        }
        return new String(swapArr);
    }
}
