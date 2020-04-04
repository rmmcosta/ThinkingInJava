package test;

import java.util.*;

class MultiThreadNotify extends Thread {
    private Subscriber subscriber;
    private PubSubMessage pubSubMessage;

    MultiThreadNotify(Subscriber subscriber, PubSubMessage pubSubMessage) {
        this.subscriber = subscriber;
        this.pubSubMessage = pubSubMessage;
    }

    public void run() {
        subscriber.runMessage(pubSubMessage);
    }
}

public class ContentServer {
    Hashtable<Topic, List<Subscriber>> topicSubscribers;
    private static ContentServer instance;

    public void notifySubscribers(Topic topic, PubSubMessage pubSubMessage) {
        List<Subscriber> subscribers = topicSubscribers.get(topic);
        for (Subscriber s : subscribers) {
            new MultiThreadNotify(s, pubSubMessage).start();
        }
    }

    public void addSubscriber(Topic topic, Subscriber subscriber) {
        if (topicSubscribers.containsKey(topic)) {
            List<Subscriber> tempSubscribers = topicSubscribers.get(topic);
            tempSubscribers.add(subscriber);
            topicSubscribers.replace(topic, tempSubscribers);
        } else {
            topicSubscribers.put(topic, new ArrayList<Subscriber>(Arrays.asList(subscriber)));
        }
    }

    private ContentServer() {
        topicSubscribers = new Hashtable<>();
    }

    public static ContentServer getInstance() {
        if (instance == null) {
            instance = new ContentServer();
        }
        return instance;
    }
}
