package graphicalUserInterfaces;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Square_V2 extends JPanel {
    private int size, x1, y1, x2, y2;
    boolean turn =false;
    public static final Dimension DIMENSION = new Dimension(400, 400);
    private double theta = 0;
    private Timer timer;
    private int velocityPercent;

    public Square_V2(int size, int velocityPercent) {
        timer = new Timer(1001 - 1000 * velocityPercent / 100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotate();
            }
        });
        setVelocityPercent(velocityPercent);
        setLayout(new BorderLayout());
        setPreferredSize(DIMENSION);
        setSize(size);
        timer.setInitialDelay(1000);
        timer.start();
    }

    public void setSize(int size) {
        if (size < this.getPreferredSize().width) {
            this.size = size;
            x1 = DIMENSION.width/2-size/2;
            x2 = DIMENSION.width/2+size/2;
            y1 = DIMENSION.height/2-size/2;
            y2 = DIMENSION.height/2+size/2;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("paint, theta:" + theta);
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        Point p1,p2,p3,p4;
        p1 = new Point(x1,y1);
        p2 = new Point(x1+size,y1);
        p3 = new Point(x1+size,y1+size);
        p4 = new Point(x1,y1+size);
        int[] x = {(int) p1.getX(), (int) p2.getX(), (int)p3.getX(), (int) p4.getX()};
        int[] y = {(int) p1.getY(), (int) p2.getY(), (int)p3.getY(), (int) p4.getY()};
        Polygon poly = new Polygon(x, y, x.length);
        g2d.rotate(theta,DIMENSION.width/2,DIMENSION.height/2);
        g2d.fill(poly);
    }

    public void rotate() {
        System.out.println("rotate");
        theta = (turn?Math.PI/4:0);
        turn=!turn;
        repaint();
    }

    public void setVelocityPercent(int velocityPercent) {
        this.velocityPercent = velocityPercent;
        timer.setDelay(1001 - 1000 * velocityPercent / 100);
    }
}

public class Ex23_RotatingSquare_V2 extends JFrame {

    public Ex23_RotatingSquare_V2() throws HeadlessException {
        Dimension slidersDimension = new Dimension(150, 25);
        //commands panel
        JPanel commandsPanel = new JPanel(new GridLayout(1, 2));
        add(commandsPanel);
        //slider panel 1
        SliderPanel sliderPanel1 = new SliderPanel();
        commandsPanel.add(sliderPanel1);
        //slider panel 2
        SliderPanel sliderPanel2 = new SliderPanel();
        commandsPanel.add(sliderPanel2);
        Square_V2 mySquare = new Square_V2(100,5);
        //content of slider panel 1
        JLabel sizeLabel = new JLabel("Square size:");
        sliderPanel1.add(sizeLabel, SwingUtilities.CENTER);
        JSlider sizeSlider = new JSlider(10, Square.DIMENSION.width*70/100, 100);
        sizeSlider.setPreferredSize(slidersDimension);
        sliderPanel1.add(sizeSlider);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mySquare.setSize(sizeSlider.getValue());
            }
        });
        //content of slider panel 2
        JLabel velocityLabel = new JLabel("Rotation speed:");
        sliderPanel2.add(velocityLabel);
        JSlider velocitySlider = new JSlider(1,100,5);
        velocitySlider.setPreferredSize(slidersDimension);
        sliderPanel2.add(velocitySlider);
        velocitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mySquare.setVelocityPercent(velocitySlider.getValue());
            }
        });
        add(mySquare);

        setResizable(false);
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Ex23_RotatingSquare_V2(),600,600);
    }
}
