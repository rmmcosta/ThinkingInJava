package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex extends JFrame {
    class MyTextArea extends JTextArea {
        String initialText;
        public MyTextArea(String text, int rows, int columns) {
            super(text, rows, columns);
            initialText = text;
            clearTextOnFocus();
        }

        private void clearTextOnFocus() {
            MyTextArea thisTextArea = this;
            this.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                    if (thisTextArea.getText().equals(thisTextArea.initialText))
                        thisTextArea.setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });
        }
    }

    class MyTextField extends JTextField {
        String initialText;
        public MyTextField(String text, int columns) {
            super(text, columns);
            initialText = text;
            clearTextOnFocus();
        }

        private void clearTextOnFocus() {
            MyTextField thisTextField = this;
            this.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                    if (thisTextField.getText().equals(thisTextField.initialText))
                        thisTextField.setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });
        }
    }

    public Regex() {
        MyTextArea text = new MyTextArea("input here the text", 9, 35);
        MyTextField regex = new MyTextField("input here the regex", 35);
        MyTextArea result = new MyTextArea("result will be presented here", 9, 35);
        JButton go = new JButton("Go");
        add(new JScrollPane(text));
        add(regex);
        add(go);
        add(new JScrollPane(result));
        InitialFocusSetter.setInitialFocus(this, go);
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = text.getText();
                Pattern pattern = Pattern.compile(regex.getText());
                Matcher matcher = pattern.matcher(inputText);
                result.setText("");
                while (matcher.find()) {
                    String textFound = inputText.substring(matcher.start(), matcher.end());
                    result.append(textFound);
                }
                if (result.getText().isEmpty()) {
                    result.setText("No matches found!");
                }
            }
        });
    }

}

class InitialFocusSetter {
    public static void setInitialFocus(Window w, Component c) {
        w.addWindowListener(new FocusSetter(c));
    }
}

class FocusSetter extends WindowAdapter {
    Component initComp;

    FocusSetter(Component c) {
        initComp = c;
    }

    public void windowOpened(WindowEvent e) {
        initComp.requestFocus();
        e.getWindow().removeWindowListener(this);
    }
}

public class Ex6_Regex {
    public static void main(String[] args) {
        Regex frame = new Regex();
        SwingConsole.runFrame(frame);
    }
}
