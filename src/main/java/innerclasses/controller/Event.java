package innerclasses.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Event {
    private long triggerTime;
    protected final long delayTime;
    private String name;
    public Event(long dTime, String n){
        name = n;
        delayTime = dTime;
        start();
    }
    //allows restart
    public void start(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Starting event at:"+dateFormat.format(date));
        triggerTime = System.nanoTime() + delayTime;
        //System.out.println(triggerTime);
    }
    public boolean ready(){
        return System.nanoTime() >= triggerTime;
    }

    @Override
    public String toString(){
        return name;
    }

    public abstract void action();
}
