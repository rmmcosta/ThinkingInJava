package graphicalUserInterfaces;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SwingConsoleSample extends JFrame {
    public static void main(String[] args) throws InterruptedException {
        SwingConsoleSample sample = new SwingConsoleSample();
        SwingConsole.runFrame(sample, 500, 500);
        JLabel label = new JLabel("Rcardo");
        sample.add(label);
        TimeUnit.SECONDS.sleep(1);
        SwingConsole.runLabelSetText(label, "Costa");
    }
}
