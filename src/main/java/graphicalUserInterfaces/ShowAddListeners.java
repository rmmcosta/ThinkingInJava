package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowAddListeners extends JFrame {
    private static final Pattern listenerPattern = Pattern.compile(".*add.*Listener.*");

    public ShowAddListeners() throws HeadlessException {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField inputClass = new JTextField();
        inputClass.setColumns(30);
        inputClass.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea resultMethods = new JTextArea();
        resultMethods.setEditable(false);
        resultMethods.setColumns(30);
        resultMethods.setRows(10);
        add(new JLabel("Class name:"));
        add(Box.createRigidArea(new Dimension(400, 5)));
        add(inputClass);
        add(Box.createRigidArea(new Dimension(400, 5)));
        JButton go = new JButton("Go");
        go.setEnabled(false);
        add(go);
        add(Box.createRigidArea(new Dimension(400, 5)));
        add(new JLabel("Methods:"));
        add(Box.createRigidArea(new Dimension(400, 5)));
        JScrollPane scrollPane = new JScrollPane(resultMethods);
        add(scrollPane);

        inputClass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                checkAndChangeButtonEnable(go, inputClass);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                checkAndChangeButtonEnable(go, inputClass);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkAndChangeButtonEnable(go, inputClass);
            }
        });

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = inputClass.getText();
                try {
                    Class<?> enteredClass = Class.forName("javax.swing." + className);
                    Method[] methods = enteredClass.getMethods();
                    resultMethods.setText("");
                    for (Method m : methods) {
                        Matcher matcher = listenerPattern.matcher(m.getName());
                        if (matcher.find())
                            resultMethods.append(m.getName() + "\n");
                    }
                    //scrollPane.getViewport().setViewPosition(new Point(0, 0));
                    //JOptionPane.showMessageDialog(((Component)e.getSource()).getParent(), scrollPane.getViewport().getViewPosition());
                    //scrollPane.getVerticalScrollBar().setValue(0);
                    //scrollPane.repaint();
                    //the only thing that seems to work when trying to auto scroll to the top is the following
                    resultMethods.setSelectionStart(0);
                    resultMethods.setSelectionEnd(0);
                } catch (ClassNotFoundException classNotFoundException) {
                    resultMethods.setText("Class not found");
                }
            }
        });

    }

    private void checkAndChangeButtonEnable(JButton go, JTextField inputClass) {
        if (inputClass.getText().isEmpty()) {
            go.setEnabled(false);
        } else {
            go.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new ShowAddListeners());
    }
}
