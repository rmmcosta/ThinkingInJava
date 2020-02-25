package test;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.MyDateTime.toDateTime;

public class GreenhouseControls extends Controller {
    public String getLights() {
        return lights;
    }

    public String getThermostat() {
        return thermostat;
    }

    public String getWater() {
        return water;
    }

    private String lights = "off", thermostat = "off", water = "off";

    public class LightsOn extends Event {

        public LightsOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lights = "on";
        }

        @Override
        public String toString() {
            return "Inside the event Lights on, the lights are: " + lights + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    public class LightsOff extends Event {

        public LightsOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            lights = "off";
        }

        @Override
        public String toString() {
            return "Inside the event Lights off, the lights are: " + lights + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = "on";
        }

        @Override
        public String toString() {
            return "Inside the event Water on, the water is: " + water + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = "off";
        }

        @Override
        public String toString() {
            return "Inside the event Water off, the water is: " + water + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    public class ThermostatOn extends Event {

        public ThermostatOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "on";
        }

        @Override
        public String toString() {
            return "Inside the event Thermostat on, the thermostat is: " + thermostat + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    public class ThermostatOff extends Event {

        public ThermostatOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "off";
        }

        @Override
        public String toString() {
            return "Inside the event Thermostat off, the thermostat is: " + thermostat + " at: " + MyDateTime.getCurrDateTime() + " and it will trigger at: " + toDateTime(this.getEventTime());
        }
    }

    //the bell always runs a new one of itself :)
    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Ding! Dong!";
        }

        @Override
        public void action() {
            GreenhouseControls.this.addEvent(new Bell(delayTime));
        }
    }

    public class Restart extends Event {
        private List<Event> eventListBackup;

        public Restart(long delayTime) {
            super(delayTime);
            eventListBackup = new ArrayList<Event>(GreenhouseControls.this.getEventList());
        }

        @Override
        public void action() {
            //foreach event just restart it
            for (Event e : eventListBackup) {
                e.start();
                GreenhouseControls.this.addEvent(e);
            }
            //if you want to run it non stop you have to do the following
            this.start();
            GreenhouseControls.this.addEvent(this);
        }

        @Override
        public String toString() {
            return "Inside the event Restart that will start at: " + toDateTime(this.getEventTime());
        }
    }

    //we must ensure that there's a way to terminate the cycle
    public class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public String toString() {
            return "Terminating...";
        }

        @Override
        public void action() {
            System.exit(0);
        }
    }
}

class GreenHouseControlsTest {
    private GreenhouseControls greenhouseControls;

    @BeforeEach
    private void Init() {
        greenhouseControls = new GreenhouseControls();
    }

    @Test
    public void LightsOnTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new LightsOn(0));
        greenhouseControls.run();
        assertEquals("on", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
    }

    @Test
    public void WaterOnTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new WaterOn(0));
        greenhouseControls.run();
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("on", greenhouseControls.getWater());
    }

    @Test
    public void ThermostatOnTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOn(0));
        greenhouseControls.run();
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("on", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
    }

    @Test
    public void LightsOffTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new LightsOn(0));
        greenhouseControls.addEvent(greenhouseControls.new LightsOff(0));
        greenhouseControls.run();
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
    }

    @Test
    public void WaterOffTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new WaterOn(0));
        greenhouseControls.addEvent(greenhouseControls.new WaterOff(0));
        greenhouseControls.run();
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
    }

    @Test
    public void ThermostatOffTest() {
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOn(0));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOff(0));
        greenhouseControls.run();
        assertEquals("off", greenhouseControls.getLights());
        assertEquals("off", greenhouseControls.getThermostat());
        assertEquals("off", greenhouseControls.getWater());
    }

    @Test
    public void ListEventsTest() {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        greenhouseControls.addEvent(greenhouseControls.new LightsOn(20000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOn(30000));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOn(25000));
        greenhouseControls.addEvent(greenhouseControls.new LightsOff(60000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOff(35000));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOff(45000));
        greenhouseControls.addEvent(greenhouseControls.new Restart(65000));
        System.out.println(greenhouseControls.getEventList());
    }
}

class GreenhouseControlsMain {
    public static void main(String[] args) {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        greenhouseControls.addEvent(greenhouseControls.new Bell(1000));
        greenhouseControls.addEvent(greenhouseControls.new LightsOn(2000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOn(3000));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOn(2500));
        greenhouseControls.addEvent(greenhouseControls.new LightsOff(6000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOff(3500));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOff(4500));
        greenhouseControls.addEvent(greenhouseControls.new Restart(6500));
        //Terminate delay passed as input to the run of the class?
        //we must add this event after the restart
        //that way the backup of the events don't have the terminate and the terminate will keeep counting
        //without restarting :)
        long terminateDelay = args.length > 0 ? Long.parseLong(args[0]) : 13100;
        greenhouseControls.addEvent(greenhouseControls.new Terminate(terminateDelay));
        greenhouseControls.run();
    }
}
