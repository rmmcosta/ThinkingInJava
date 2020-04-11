package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\n java TestRegularExpression characterSequence regex+");
            System.exit(0);
        }
        String text = args[0];
        //now let's get the regex's
        Pattern pattern;
        Matcher matcher;
        for (int i = 1; i < args.length; i++) {
            pattern = Pattern.compile(args[i]);
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                String textFound = text.substring(matcher.start(),matcher.end());
                if (textFound.isEmpty()) {
                    continue;
                }
                System.out.println(textFound);
            }
        }
    }
}
