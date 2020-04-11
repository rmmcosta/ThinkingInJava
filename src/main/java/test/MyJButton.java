package test;

import graphicalUserInterfaces.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Button1 extends JFrame {
    JLabel label;
    private static void buttonClick(final JButton button, final JTextField textField){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(button.getText());
            }
        });
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btnText = ((JButton) e.getSource()).getText();
            label.setText(btnText);
        }
    }

    public Button1() throws HeadlessException {
        setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JTextField textField = new JTextField("Click a button...");
        add(button1);
        add(button2);
        add(textField);
        buttonClick(button1, textField);
        buttonClick(button2, textField);
        JButton btnLabel = new JButton("Button label 1");
        JButton btnLabel2 = new JButton("Button label 2");
        add(btnLabel);
        add(btnLabel2);
        ButtonListener buttonListener = new ButtonListener();
        btnLabel.addActionListener(buttonListener);
        btnLabel2.addActionListener(buttonListener);
        label = new JLabel("Click one of the button labels");
        add(label);
    }
}

public class MyJButton {
    public static void main(String[] args) {
        SwingConsole.runFrame(new Button1(),400,400);
    }
}
