package test;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HelloLabel extends JFrame {
    JLabel[] labels;

    public HelloLabel() throws HeadlessException {
        super("Hello Swing");
        /*Container content = getContentPane();
        content.setLayout(new GridLayout(2, 2));*/
        setLayout(new FlowLayout());
        labels = new JLabel[2];
        labels[0] = new JLabel("A Label");
        /*labels[0].setHorizontalTextPosition(JLabel.LEFT);
        labels[0].setVerticalTextPosition(JLabel.TOP);*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);
        labels[1] = new JLabel("A Label 1");
        /*labels[1].setHorizontalTextPosition(JLabel.LEFT);
        labels[1].setVerticalTextPosition(JLabel.BOTTOM);*/
        add(labels[0]);
        add(labels[1]);
    }

    public HelloLabel(String title) throws HeadlessException {
        super(title);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);

        Random random = new Random();
        int numLabels = random.nextInt(15) + 1;
        labels = new JLabel[numLabels];
        for (int i = 0; i < numLabels; i++) {
            add(labels[i] = new JLabel("Label " + i));
        }
    }

    static HelloLabel helloLabel;

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                helloLabel = new HelloLabel("Hello Swing");
            }
        });
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (JLabel label : helloLabel.labels) {
                    label.setText("Hey! This is different!");
                }
            }
        });
    }
}
