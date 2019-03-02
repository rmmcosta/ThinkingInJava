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

    public Event getLightsON(){
        return new LightsON(1000000000);
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

    public static void main(String[] args){
        GreenhouseControls gc = new GreenhouseControls();
        gc.add(gc.getLightsON());
        gc.go();
        gc.add(gc.new WaterOn(2000000000));
        gc.go();
        gc.go();
    }
}
