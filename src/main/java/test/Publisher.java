package test;

public interface Publisher {
    public void sendMessage(Topic topic, PubSubMessage pubSubMessage);
}
