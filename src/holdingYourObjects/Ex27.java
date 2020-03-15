package holdingYourObjects;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    private String theString;

    public Command(String theString) {
        this.theString = theString;
    }

    public void operation() {
        System.out.println(theString);
    }

    @Override
    public String toString() {
        return theString;
    }
}

class Consumer {
    public static void process(Queue<Command> commands) {
        for (Command c : commands) {
            c.operation();
        }
    }
    public static void processAndDiscard(Queue<Command> commands) {
        while (commands.peek() != null) {
            commands.remove().operation();
        }
    }
}

public class Ex27 {
    public static void main(String[] args) {
        Queue<Command> theCommands = randomCommands();
        System.out.println(theCommands);
        Consumer.process(theCommands);
        System.out.println(theCommands);
        Consumer.processAndDiscard(theCommands);
        System.out.println(theCommands);
    }

    public static Queue<Command> randomCommands() {
        Queue<Command> theCommands = new LinkedList<>();
        String[] theStrings = {"Open Door", "Put belt", "Insert key", "Turn key", "Remove hand break", "Put 1st gear", "Gas"};
        for (String s : theStrings) {
            theCommands.offer(new Command(s));
        }
        return theCommands;
    }
}
