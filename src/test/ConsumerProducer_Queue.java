package test;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    private final String cmd;

    Command(String cmd) {
        this.cmd = cmd;
    }

    public void operation() {
        System.out.println(cmd);
    }

    @Override
    public String toString() {
        return cmd;
    }
}

class Producer {
    public static void produce(Queue<Command> theCommands) {
        String[] theStrings = {"Open Door", "Put belt", "Insert key", "Turn key", "Remove hand break", "Put 1st gear", "Gas"};
        for (String s : theStrings) {
            theCommands.offer(new Command(s));
        }
    }
}

class Consumer {
    public static void consume(Queue<Command> theCommands) {
        while (theCommands.peek() != null) {
            theCommands.remove().operation();
        }
    }
}

public class ConsumerProducer_Queue {
    public static void main(String[] args) {
        //in this case the main method is acting as the controller
        Queue<Command> theCommands = new LinkedList<>();
        Producer.produce(theCommands);
        Consumer.consume(theCommands);
    }
}
