package test;

import java.util.Arrays;

interface Processor {
    public String getName();

    public Object process(Object input);
}

abstract class StringProcessor implements Processor {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);
}

class DownCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class UpperCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Split extends StringProcessor {
    @Override
    public String process(Object input) {
        String stringInput = (String) input;
        String[] splits = stringInput.split(" ");
        return Arrays.toString(splits);
    }
}

public class Apply {
    private static final String message = "This is my message to the world!";

    public static void process(Processor p, Object s) {
        System.out.println(p.getName());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        //instead of having to repeat all the code we can
        //just use the static process method to do it
        StringProcessor spDownCase = new DownCase();
        StringProcessor spUpperCase = new UpperCase();
        StringProcessor spSplit = new Split();
        process(spDownCase, message);
        process(spUpperCase, message);
        process(spSplit, message);
    }


}
