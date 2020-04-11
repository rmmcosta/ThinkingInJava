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
        System.out.println("Another Begin --------------------");
        GreenhouseControlsLinked gcl = new GreenhouseControlsLinked();
// Instead of hard-wiring, you could parse
// configuration information from a text file here:
        gcl.add(gcl.getBell(900));
        Event[] eventListl = {
                gcl.getThermostatNight(0),
                gcl.getLightsON(200),
                gcl.getLightsOff(400),
                gcl.getWaterOn(600),
                gcl.getWaterOff(800),
                gcl.getThermostatDay(1400)
        };
        gcl.add(gcl.getRestart(2000, eventListl));
        gcl.go();
    }
}
