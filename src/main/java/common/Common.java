package common;

public class Common {
    public static Character[] charArray2CharacterArray(char[] charArray) {
        Character[] tempArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            tempArray[i] = charArray[i];
        }
        return tempArray;
    }
}
