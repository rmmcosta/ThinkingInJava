package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;

public class MyGridLayout extends JFrame {
    public MyGridLayout() throws HeadlessException {
        setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 21; i++) {
            add(new JButton("Button" + (i+1)));
        }
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new MyGridLayout(), 350, 300);
    }
}

