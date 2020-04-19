package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;

public class Faces extends JFrame {
    public Faces() throws HeadlessException {
        Icon icon = new ImageIcon("/home/ricardo/Documents/javaclasspath/Button-Next-icon.png");
        JButton button = new JButton("button", icon);
        add(button);
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Faces());
    }
}
