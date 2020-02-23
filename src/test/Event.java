package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static test.MyDateTime.getCurrDateTime;
import static test.MyDateTime.toDateTime;

public abstract class Event {
    private long eventTime;
    private final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        System.out.println("Current time: " + toDateTime(System.currentTimeMillis()));
        eventTime = System.currentTimeMillis() + delayTime;
        System.out.println("Event time: " + toDateTime(eventTime));
    }

    public Boolean ready() {
        return System.currentTimeMillis() >= eventTime;
    }

    public abstract void action();
}

class EventXpto extends Event {

    public EventXpto(long delayTime) {
        super(delayTime);
    }

    @Override
    public void action() {
        System.out.println("I've done what you asked!");
    }
}

class EventMain {
    public static void main(String[] args) {
        System.out.println(getCurrDateTime());
        Event event = new EventXpto(10000);
        while (!event.ready()) {
            //System.out.println("not yet");
        }
        event.action();
        System.out.println(getCurrDateTime());
    }
}