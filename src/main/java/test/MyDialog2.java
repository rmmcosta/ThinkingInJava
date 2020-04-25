package test;

import graphicalUserInterfaces.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class MyDialog2 {
    public static void main(String[] args) {
        JFrame theFrame = new JFrame();
        SwingConsole.runFrame(theFrame);
        JDialog myDialog = new JDialog(theFrame);
        myDialog.add(new JLabel("Just text"));
        //myDialog.pack();
        myDialog.setMinimumSize(new Dimension(200,200));
        myDialog.setLocationRelativeTo(theFrame);
        myDialog.setVisible(true);
    }
}
