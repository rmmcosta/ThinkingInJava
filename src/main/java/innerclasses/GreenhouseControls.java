package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

public class GreenhouseControls extends Controller {
    private class LightsON extends Event{

        public LightsON(long dTime) {
            super(dTime, "Ligths ON");
        }

        @Override
        public void action() {
            System.out.println("Turning the lights ON...");
        }
    }

    public Event getLightsON(long dTime){
        return new LightsON(dTime);
    }

    private class LightsOff extends Event{

        public LightsOff(long dTime) {
            super(dTime, "Ligths Off");
        }

        @Override
        public void action() {
            System.out.println("Turning the lights Off...");
        }
    }

    public Event getLightsOff(long dTime){
        return new LightsOff(dTime);
    }

    private class WaterOn extends Event{

        private WaterOn(long dTime) {
            super(dTime, "Water On");
        }

        @Override
        public void action() {
            System.out.println("Turning the water ON...");
        }
    }

    public Event getWaterOn(long dTime) { return new WaterOn(dTime);}

    private class WaterOff extends Event{

        private WaterOff(long dTime) {
            super(dTime, "Water Off");
        }

        @Override
        public void action() {
            System.out.println("Turning the water Off...");
        }
    }

    public Event getWaterOff(long dTime) { return new WaterOff(dTime);}

    private class Bell extends Event{

        private Bell(long dTime) {
            super(dTime, "Bell ringing");
        }

        @Override
        public void action() {
            System.out.println("Turning the Bell on...");
        }
    }

    public Event getBell(long dTime) { return new Bell(dTime);}

    private class ThermostatNight extends Event{

        private ThermostatNight(long dTime) {
            super(dTime, "ThermostatNight");
        }

        @Override
        public void action() {
            System.out.println("Turning the ThermostatNight on...");
        }
    }

    public Event getThermostatNight(long dTime) { return new ThermostatNight(dTime);}

    private class ThermostatDay extends Event{

        private ThermostatDay(long dTime) {
            super(dTime, "ThermostatDay");
        }

        @Override
        public void action() {
            System.out.println("Turning the ThermostatDay on...");
        }
    }

    public Event getThermostatDay(long dTime) { return new ThermostatDay(dTime);}

    private class Restart extends Event{
        Event[] events;

        private Restart(long dTime, Event[] eventList) {
            super(dTime, "Restart");
            events = eventList;
        }

        @Override
        public void action() {
            for(Event e: events) {
                e.action();
            }
        }
    }

    public Event getRestart(long dTime, Event[] events) { return new Restart(dTime,events);}

    public static void main(String[] args){
        GreenhouseControls gc = new GreenhouseControls();
        gc.add(gc.getLightsON(1000));
        gc.go();
        gc.add(gc.new WaterOn(2000000000));
        gc.go();
        gc.go();
    }
}
