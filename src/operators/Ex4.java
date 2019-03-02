package operators;

public class Ex4 {
    public static void main(String[] args) {
        if(args.length < 2){
            System.err.println("Two arguments must be passed: Distance in meters and time in seconds");
            System.exit(1);
        }
        float distance = Float.parseFloat(args[0]);
        float time = Float.parseFloat(args[1]);
        float velocity = distance/time;
        System.out.println("Velocity="+velocity+"m/s");
    }
}
