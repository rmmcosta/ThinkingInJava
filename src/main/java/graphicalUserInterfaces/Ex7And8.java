package graphicalUserInterfaces;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ex7And8 extends JFrame {
    private JTextField textField;
    class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem source = (JMenuItem)(e.getSource());
            textField.setText(source.getText());
        }
    }
    public Ex7And8() {
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        textField = new JTextField(30);
        add(textField);
        JCheckBox checkBox = new JCheckBox("Select me");
        checkBox.setCursor(handCursor);
        add(checkBox);
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(checkBox.getText() + ": " + checkBox.isSelected());
            }
        });
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Coiso", "Cenas", "e tal"});
        add(comboBox);
        comboBox.setCursor(handCursor);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(comboBox.getItemAt(comboBox.getSelectedIndex()));
            }
        });
        JFileChooser fileChooser = new JFileChooser(".");
        add(fileChooser);
        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(fileChooser.getSelectedFile().getName());
            }
        });
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        DateFormatter dateFormatter  = new DateFormatter(dateFormat);
        JFormattedTextField formattedTextField = new JFormattedTextField(dateFormatter);
        formattedTextField.setColumns(10);
        add(formattedTextField);
        formattedTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(formattedTextField.getText());
            }
        });
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menu.setCursor(handCursor);
        menu.setSize(100,100);
        JMenuItem item1 = new JMenuItem("item 1"),
                item2 = new JMenuItem("item 2"),
                item3 = new JMenuItem("item 3");
        item1.setSize(50,50);
        item1.setCursor(handCursor);
        item2.setSize(50,50);
        item2.setCursor(handCursor);
        item3.setSize(50,50);
        item3.setCursor(handCursor);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        add(new JLabel("Menu"));
        menuBar.add(menu);
        add(menuBar);
        MenuItemListener menuItemListener = new MenuItemListener();
        item1.addActionListener(menuItemListener);
        item2.addActionListener(menuItemListener);
        item3.addActionListener(menuItemListener);
        JPanel panel = new JPanel();
        panel.add(new JLabel("pass"));
        JPasswordField passwordField = new JPasswordField(10);
        panel.add(passwordField);
        add(panel);
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(new String(passwordField.getPassword()));
            }
        });
        JRadioButton radioButton = new JRadioButton("radio 1");
        radioButton.setCursor(handCursor);
        add(radioButton);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(radioButton.getText() + ": " + radioButton.isSelected());
            }
        });
        JToggleButton toggleButton = new JToggleButton("toggle me");
        toggleButton.setCursor(handCursor);
        add(toggleButton);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(toggleButton.getText() + ": " + toggleButton.isSelected());
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Ex7And8(), 800, 600);
    }
}
