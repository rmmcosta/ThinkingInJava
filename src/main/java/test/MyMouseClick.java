package test;

import graphicalUserInterfaces.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        JButton button = new JButton("b");
        add(button);
        button.addMouseListener(new MyMouseClick(this));
    }
}

public class MyMouseClick extends MouseAdapter {
    private Component parentComponent;
    public MyMouseClick(Component parentComponent) {
        this.parentComponent = parentComponent;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(parentComponent, "Mouse click!");
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new MyFrame());
    }
}
