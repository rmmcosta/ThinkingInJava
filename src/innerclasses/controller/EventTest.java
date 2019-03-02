package innerclasses.controller;

import javax.naming.ldap.Control;

class FootballGame extends Event{

    public FootballGame(long dTime) {
        super(dTime+10, "Football Game");
    }

    @Override
    public void action() {
        System.out.println("Kickof football game!");
    }
}

public class EventTest {
    public static void main(String[] args){
        System.out.println(System.nanoTime());
        FootballGame fg = new FootballGame(15000000);
        System.out.println(System.nanoTime());
        while(!fg.ready()){System.out.println("Waiting...");};
        fg.action();
        System.out.println(System.nanoTime());

        while(!fg.ready()){System.out.println("Waiting...");};
        fg.action();
        System.out.println(System.nanoTime());
        fg.start();

        System.out.println(System.nanoTime());

        while(!fg.ready()){System.out.println("Waiting...");};
        fg.action();

        Controller c = new Controller();
        c.add(fg);
        Event e1 = new Event(13999999, "Basquette") {
            @Override
            public void action() {
                System.out.println("Go for the basket");
            }
        };
        c.show();
        c.add(e1);
        c.show();
        c.remove(fg);
        c.show();
    }
}
