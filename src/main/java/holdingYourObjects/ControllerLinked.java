package holdingYourObjects;

import innerclasses.controller.Event;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ControllerLinked {
    private List<Event> events = new LinkedList<Event>();
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
        Iterator<Event> it = events.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public void go(){
        List<Event> cloneEvents = new LinkedList<Event>(events); // this is because of the remove instruction.
        // And we need a real copy not a pointer to the old one
        Iterator<Event> it = cloneEvents.iterator();
        while(it.hasNext()) {
            Event e = it.next();
            if(e.ready()) {
                System.out.println(e);
                e.action();
                remove(e);
            }
        }
    }
}
