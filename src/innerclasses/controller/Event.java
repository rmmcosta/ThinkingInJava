package innerclasses.controller;

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
        System.out.println(System.nanoTime());
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
