package graphicalUserInterfaces;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Ex22_RGB extends JFrame {
    private JPanel colorPanel;
    private JSlider sliderRed,
            sliderGreen,
            sliderBlue;
    private JLabel colorLabel;

    private void updateColor() {
        colorPanel.setBackground(new Color(sliderRed.getValue(), sliderGreen.getValue(), sliderBlue.getValue()));
        colorLabel.setText(String.format("RGB(%d,%d,%d)",
                sliderRed.getValue(),
                sliderBlue.getValue(),
                sliderGreen.getValue()));
    }

    public Ex22_RGB() throws HeadlessException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel();
        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(400, 200));
        colorLabel = new JLabel("", SwingConstants.CENTER);
        mainPanel.add(colorLabel, BorderLayout.SOUTH);
        sliderRed = new JSlider(0, 255);
        sliderGreen = new JSlider(0, 255);
        sliderBlue = new JSlider(0, 255);
        sliderRed.setBackground(Color.red);
        sliderRed.setForeground(Color.black);
        sliderGreen.setBackground(Color.green);
        sliderGreen.setForeground(Color.black);
        sliderBlue.setBackground(Color.blue);
        sliderBlue.setForeground(Color.black);
        sliderRed.addChangeListener(sliderNewValue());
        sliderBlue.addChangeListener(sliderNewValue());
        sliderGreen.addChangeListener(sliderNewValue());
        panel1.add(sliderRed);
        panel1.add(sliderGreen);
        panel1.add(sliderBlue);
        add(mainPanel);
        mainPanel.add(panel1, BorderLayout.NORTH);
        mainPanel.add(colorPanel, BorderLayout.CENTER);
        updateColor();
    }

    @NotNull
    private ChangeListener sliderNewValue() {
        return new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        };
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Ex22_RGB(), 650, 300);
    }
}
