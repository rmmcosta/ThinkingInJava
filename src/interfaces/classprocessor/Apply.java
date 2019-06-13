package interfaces.classprocessor;

import java.util.Arrays;

class Processor {
    String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor{
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor{
    String process(Object input) {
        return Arrays.toString(((String) input).split(""));
    }
}

public class Apply{
    static void process(Processor p, Object s) {
        System.out.println(p.name());
        System.out.println(p.process(s));
    }

    public static String s = "Once upon a timeUtilities...";

    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(), s);
    }
}
