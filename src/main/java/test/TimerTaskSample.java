package test;

import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("timer task");
    }
}

public class TimerTaskSample {
    public static void main(String[] args) {
        new Timer().schedule(new MyTimerTask(), 0, 1000);
    }
}
