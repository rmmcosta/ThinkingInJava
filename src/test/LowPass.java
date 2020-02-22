package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowPass extends Filter {
    double lowCutOff;

    public LowPass() {
        lowCutOff = 1.0;
    }
    public LowPass(double lowCutOff) {
        this.lowCutOff = lowCutOff;
    }

    @Override
    public String getName() {
        return "Low pass filter with a low cutoff of: " + lowCutOff;
    }

    public static void main(String[] args) {

    }
}

class LowPassTest {
    private static LowPass lp1;
    private static final double cutoff = 4.5;
    @BeforeAll
    public static void init() {
        lp1 = new LowPass(cutoff);
    }
    @Test
    public void testGetName() {
        String expected = "Low pass filter with a low cutoff of: " + cutoff;
        assertEquals(expected, lp1.getName());
    }
}

class LowPassMain {
    public static void main(String[] args) {
        LowPass lp1 = new LowPass(4.5);
        System.out.println(lp1.getName());
    }
}