package test;

public class Waveform {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform with id: " + id;
    }

    public static void main(String[] args) {
        Waveform w1 = new Waveform();
        Waveform w2 = new Waveform();
        System.out.println(w1);
        System.out.println(w2);
    }
}
