package test;

public class PubSubSample {
    public static void main(String[] args) {
        ContentServer contentServer = ContentServer.getInstance();
        Publisher sicNoticias = new Publisher() {
            public void sendMessage(Topic topic, PubSubMessage pubSubMessage) {
                contentServer.notifySubscribers(topic, pubSubMessage);
            }
        };
        Subscriber jose = new Subscriber() {
            @Override
            public void runMessage(PubSubMessage pubSubMessage) {
                News news = (News) pubSubMessage;
                printMessage(news);
            }
            private void printMessage(News news) {
                System.out.println("José:");
                news.printNews();
            }
        };
        Subscriber ricardo = new Subscriber() {
            @Override
            public void runMessage(PubSubMessage pubSubMessage) {
                News news = (News) pubSubMessage;
                System.out.println("Ricardo:");
                news.printNews();
            }
        };
        contentServer.addSubscriber(Topic.MEDICAL, jose);
        contentServer.addSubscriber(Topic.FOOTBALL, ricardo);
        contentServer.addSubscriber(Topic.MEDICAL, ricardo);
        News news1 = new News("Covid-19", "Last minute, app #todosporum is live!");
        News news2 = new News("LPF", "All football competitions are on hold!");
        sicNoticias.sendMessage(Topic.MEDICAL, news1);
        sicNoticias.sendMessage(Topic.FOOTBALL, news2);
    }
}
