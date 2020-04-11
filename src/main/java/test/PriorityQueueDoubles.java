package test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDoubles {
    public static void processPoll(Queue queue) {
        //poll -> This method returns the element at the front of
        // the container or the head of the Queue. It returns null when the Queue is empty.
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void processPollFor(Queue queue) {
        //poll -> This method returns the element at the front of
        // the container or the head of the Queue. It returns null when the Queue is empty.
        for (Object object = queue.poll(); object != null ; object = queue.poll()) {
            System.out.println(object);
        }
    }

    public static void processPeek(Queue queue) {
        while (queue.peek() != null) {
            System.out.println(queue.remove());
        }
    }

    public static void main(String[] args) {
        Double[] doublesArray = {5.0, 2.0, 3.0, 7.0};
        PriorityQueue<Double> doubles = new PriorityQueue<Double>(Arrays.asList(doublesArray));
        System.out.println(doubles);
        doubles.offer(1.0);
        doubles.offer(11.5);
        processPoll(doubles);
        doubles = new PriorityQueue<Double>(Arrays.asList(doublesArray));
        processPollFor(doubles);
        doubles = new PriorityQueue<Double>(Arrays.asList(doublesArray));
        processPeek(doubles);
    }
}
