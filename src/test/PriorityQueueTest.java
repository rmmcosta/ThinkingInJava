package test;

import org.jetbrains.annotations.NotNull;
import java.util.*;

class Message implements Comparable<Message> {
    private final int priority;
    private final String msg;

    Message(String msg, int priority) {
        this.priority = priority;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    @Override
    public int compareTo(@NotNull Message message) {
        return this.priority > message.priority ? -1 : this.priority == message.priority ? 0 : 1;
    }

    public static void process(PriorityQueue<Message> messages) {
        while (messages.peek() != null) {
            System.out.println(messages.remove());
        }
    }
}

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Message> messages = new PriorityQueue<Message>();
        messages.offer(new Message("Goodbye", 2));
        messages.offer(new Message("Careful",5));
        messages.offer(new Message("Hello", 1));
        Message.process(messages);
    }
}
