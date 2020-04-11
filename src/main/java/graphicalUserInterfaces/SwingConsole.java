package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;

public class SwingConsole {

    public static void runFrame(final JFrame frame) {
        runFrame(frame, 400, 400, new FlowLayout(), true);
    }

    public static void runFrame(final JFrame frame, final int width, final int height) {
        runFrame(frame, width, height, new FlowLayout(), true);
    }

    public static void runFrame(final JFrame frame, final boolean visible) {
        runFrame(frame, 400, 400, new FlowLayout(), visible);
    }

    public static void runFrame(final JFrame frame, final int width, final int height, final LayoutManager layoutManager, final boolean visible) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setLayout(layoutManager);
                frame.setTitle(frame.getClass().getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(visible);
                frame.setSize(width,height);
            }
        });
    }

    public static void runLabelSetText(final JLabel label, final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText(text);
            }
        });
    }
}
