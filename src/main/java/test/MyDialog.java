package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyDialog {
    private static int index;
    private static JFrame parentFrame;

    static class OpenAction extends AbstractAction {
        public OpenAction(JFrame theFrame) {
            super("Open");
            parentFrame = theFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jd = new JDialog();
            //jd.setLocation(parentFrame.getLocation());
            jd.setPreferredSize(new Dimension(200,200));
            jd.setTitle("D" + String.valueOf(++index));
            jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jd.add(new JButton(new OpenAction(parentFrame)));
            jd.pack();
            jd.setLocationRelativeTo(parentFrame);
            jd.setVisible(true);
        }
    }

    private void display() {
        JFrame f = new JFrame();
        parentFrame = f;
        f.setPreferredSize(new Dimension(400,400));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JButton(new OpenAction(f)));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {

        new MyDialog().display();

    }
}
