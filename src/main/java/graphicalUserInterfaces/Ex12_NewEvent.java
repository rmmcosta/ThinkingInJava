package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

class MyButton extends JButton {
    private void alert(EventObject event, String message) {
        Component component = ((Component) event.getSource()).getParent();
        JOptionPane.showMessageDialog(component, message);
    }
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alert(e, e.getActionCommand());
        }
    };
    FocusListener fl = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("focus gained");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("focus lost");
        }
    };
    public MyButton(Color color, String label) {
        super(label);
        setBackground(color);
        addActionListener(al);
        addFocusListener(fl);
    }
}

public class Ex12_NewEvent extends JFrame {
    private static Map<String, JTextField> stringJTextFieldMap = new HashMap<String, JTextField>();
    private static String[] events = {"actionPerformed","focusGained"};

    public Ex12_NewEvent() throws HeadlessException {
        setLayout(new FlowLayout());
        add(new MyButton(Color.BLUE, events[0]));
        add(new MyButton(Color.GREEN, events[1]));
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Ex12_NewEvent());
    }
}
