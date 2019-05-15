package holdingYourObjects;
import innerclasses.GreenhouseControls;
import innerclasses.controller.Event;

public class Ex13_LinkedList {
    public static void main(String[] args) {
        System.out.println("Begin --------------------");
        GreenhouseControls gc = new GreenhouseControls();
// Instead of hard-wiring, you could parse
// configuration information from a text file here:
        gc.add(gc.getBell(900));
        Event[] eventList = {
                gc.getThermostatNight(0),
                gc.getLightsON(200),
                gc.getLightsOff(400),
                gc.getWaterOn(600),
                gc.getWaterOff(800),
                gc.getThermostatDay(1400)
        };
        gc.add(gc.getRestart(2000, eventList));
        gc.go();
    }
}
