package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            return "Inside the event Lights on, the lights are: " + lights + " at: " + MyDateTime.getCurrDateTime();
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
            return "Inside the event Lights off, the lights are: " + lights + " at: " + MyDateTime.getCurrDateTime();
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
            return "Inside the event Water on, the water is: " + water + " at: " + MyDateTime.getCurrDateTime();
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
            return "Inside the event Water off, the water is: " + water + " at: " + MyDateTime.getCurrDateTime();
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
            return "Inside the event Thermostat on, the thermostat is: " + thermostat + " at: " + MyDateTime.getCurrDateTime();
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
            return "Inside the event Thermostat off, the thermostat is: " + thermostat + " at: " + MyDateTime.getCurrDateTime();
        }
    }

    public class Restart extends Event {
        private List<Event> eventListBackup;

        public Restart(long delayTime) {
            super(delayTime);
            eventListBackup = GreenhouseControls.this.getEventList();
        }

        @Override
        public void action() {
            for (Event e : eventListBackup) {
                GreenhouseControls.this.addEvent(e);
            }
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
}

class GreenHouseControlsMain {
    public static void main(String[] args) {
        GreenhouseControls greenhouseControls = new GreenhouseControls();
        greenhouseControls.addEvent(greenhouseControls.new LightsOn(20000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOn(30000));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOn(25000));
        greenhouseControls.addEvent(greenhouseControls.new LightsOff(60000));
        greenhouseControls.addEvent(greenhouseControls.new WaterOff(35000));
        greenhouseControls.addEvent(greenhouseControls.new ThermostatOff(45000));
        greenhouseControls.addEvent(greenhouseControls.new Restart(65000));
        greenhouseControls.run();
    }
}
