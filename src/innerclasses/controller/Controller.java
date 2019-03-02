package innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> events = new ArrayList<Event>();
    public void add(Event e){
        events.add(e);
    }
    public int size(){
        return events.size();
    }
    public void remove(Event e){
        events.remove(e);
    }
    public void show(){
        for (Event e: events
             ) {
            System.out.println(e);
        }
    }
    public void go(){
        while (events.size() > 0) {
            for (Event e:
                    new ArrayList<>(events)) {
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    remove(e);
                }
            }
        }
    }
}
