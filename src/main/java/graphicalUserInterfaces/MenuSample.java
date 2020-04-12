package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSample extends JFrame {
    private JPanel mainPanel;
    private JMenuBar mainMenuBar;
    private JMenu mainMenu;
    private JMenuItem item1;
    private JMenuItem item2;
    private JTextField textField1;
    private JPanel infoPanel;

    public MenuSample() {
        this.setContentPane(mainPanel);
        this.pack();
        add(mainMenuBar);
        mainMenuBar.add(mainMenu);
        mainMenu.setText("Menu");
        item1.setText("item 1");
        item2.setText("item 2");
        mainMenu.add(item1);
        mainMenu.add(item2);
        setJMenuBar(mainMenuBar);
        add(infoPanel);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(item1.getText());
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(item2.getText());
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new MenuSample());
    }
}
