package test;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void run() {
        //always iterate trough the list while the list is not empty
        //if the event is ready, run the action and remove it from the list
        // to do that we must always duplicate the list
        while (!eventList.isEmpty()) {
            for (Event e : new ArrayList<Event>(eventList)) {
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}

class ControllerTest {
    static class EventTest extends Event {

        public EventTest(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.out.println("test action executed! -> " + this);
        }
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addEvent(new EventTest(30));
        controller.addEvent(new EventTest(1900000000));
        controller.run();
    }
}
