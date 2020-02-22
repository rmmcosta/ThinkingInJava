package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Filter {
    public String getName() {
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input) {
        return input;
    }
}

class TestFilter {
    @Test
    public void testName() {
        Filter f1 = new Filter();
        assertEquals("Filter", f1.getName(), "The name of the class must be Filter!");
    }

    @Test
    public void testProcess() {
        Filter f1 = new Filter();
        Waveform w1 = new Waveform();
        assertEquals(w1, f1.process(w1), "The waveform must be the same!");
    }
}
