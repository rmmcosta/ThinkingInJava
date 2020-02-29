package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;

public class EvaluateExpressions {
    Stack<Character> characterStack;
    String expression;

    public EvaluateExpressions(String expression) {
        this.expression = expression;
        characterStack = new Stack<Character>();
    }

    public void evaluate() {
        char[] chars = expression.toCharArray();
        System.out.println(Arrays.toString(chars));
        HashMap<Character, Consumer<Character>> functionMap = new HashMap<Character, Consumer<Character>>();
        functionMap.put('+', (c) -> {
//            System.out.println("inside + : " + c);
            characterStack.push(c);
        });
        functionMap.put('-', (c) -> {
//            System.out.println("inside - : " + c);
            System.out.print(characterStack.pop());
        });

        Consumer<Character> currFunction = null;
        for (char c : chars) {
            if (functionMap.containsKey(c)) {
//                System.out.println("Operation: " + c);
                currFunction = functionMap.get(c);
                if (c == '-') {
                    currFunction.accept(c);
                }
            } else {
//                System.out.println("Character: " + c);
//                System.out.println("currfunction: " + currFunction);
                if (currFunction != null) {
                    currFunction.accept(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        EvaluateExpressions myExpression = new EvaluateExpressions("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
        myExpression.evaluate();
    }
}
