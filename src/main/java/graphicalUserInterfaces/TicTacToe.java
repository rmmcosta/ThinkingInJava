package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends JFrame {
    private final JTextField rows = new JTextField("3");
    private final JTextField cols = new JTextField("3");

    public TicTacToe() throws HeadlessException {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Rows", JLabel.CENTER));
        p.add(rows);
        p.add(new JLabel("Cols", JLabel.CENTER));
        p.add(cols);
        add(p, BorderLayout.NORTH);
        JButton b = new JButton("go");
        b.addActionListener(new BL(this));
        add(b, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new TicTacToe(), 200, 200);
    }

    private class BL implements ActionListener {
        private TicTacToe parentTicTacToe;

        private BL(TicTacToe parentTicTacToe) {
            this.parentTicTacToe = parentTicTacToe;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog d = new ToeDialog(Integer.valueOf(rows.getText()), Integer.valueOf(cols.getText()), parentTicTacToe);
            d.setVisible(true);
        }
    }

    private enum State {BLANK, X, O}

    private enum Status {WIN, DRAW, CONTINUE}

    static class ToeDialog extends JDialog {
        private State turn = State.X;
        private TicTacToe parentTicTacToe;

        public ToeDialog(int rows, int cols, TicTacToe parentTicTacToe) {
            this.parentTicTacToe = parentTicTacToe;
            setTitle("New Game");
            setLayout(new GridLayout(rows, cols));
            for (int i = 0; i < rows * cols; i++) {
                add(new ToeButton());
            }
            setSize(cols * 50, rows * 50);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        private class ToeButton extends JPanel {
            private State state = State.BLANK;

            @Override
            public Component[] getComponents() {
                return super.getComponents();
            }

            public ToeButton() {
                addMouseListener(new ML());
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x1 = 0,
                        y1 = 0,
                        x2 = getSize().width - 1,
                        y2 = getSize().height - 1;
                g.drawRect(x1, y1, x2, y2);
                x1 = x2 / 4;
                y1 = y2 / 4;
                int wide = x2 / 2, high = y2 / 2;
                if (state == State.X) {
                    //draw an X
                    g.drawLine(x1, y1, x1 + wide, y1 + high);
                    g.drawLine(x1, y1 + high, x1 + wide, y1);
                }
                if (state == State.O) {
                    g.drawOval(x1, y1, wide, high);
                }
            }

            private class ML implements MouseListener {
                @Override
                public void mouseClicked(MouseEvent e) {
                    state = turn;
                    turn = turn == State.X ? State.O : State.X;
                    repaint();
                    Component[] components = ((JPanel) e.getSource()).getParent().getComponents();
                    int cols = Integer.valueOf(parentTicTacToe.cols.getText());
                    int rows = Integer.valueOf(parentTicTacToe.rows.getText());
                    Status status = evaluateStatus(components, cols, rows);
                    Container parentContainer = ((JPanel) e.getSource()).getParent().getParent();
                    if (status == Status.WIN) {
                        JOptionPane.showMessageDialog(parentContainer, state + " - You Win!");
                        //parentContainer.setVisible(false);
                    }
                    if (status == Status.DRAW) {
                        JOptionPane.showMessageDialog(parentContainer, "It's a Draw!");
                        //parentContainer.setVisible(false);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            }

            private Status evaluateStatus(Component[] toeButtons, int rows, int cols) {
                // we need to check rows, columns, and 2 of the 4 corners if rows == cols
                //columns
                for (int i = 0; i < cols; i++) {
                    State prevState = ((ToeButton) toeButtons[i]).state;
                    boolean isEqualColumns = prevState != State.BLANK;
                    for (int j = i + cols; j < cols * rows; j += cols) {
                        State currState = ((ToeButton) toeButtons[j]).state;
                        if (prevState != currState) {
                            isEqualColumns = false;
                            break;
                        }
                    }
                    if (isEqualColumns) {
                        System.out.println("is equal columns");
                        return Status.WIN;
                    }
                }
                //rows
                for (int i = 0; i <= rows * cols - cols; i += cols) {
                    State prevState = ((ToeButton) toeButtons[i]).state;
                    boolean isEqualRows = prevState != State.BLANK;
                    ;
                    for (int j = i + 1; j < i + cols; j++) {
                        State currState = ((ToeButton) toeButtons[j]).state;
                        if (prevState != currState) {
                            isEqualRows = false;
                            break;
                        }
                    }
                    if (isEqualRows) {
                        System.out.println("is equal rows");
                        return Status.WIN;
                    }
                }
                //corners
                if (rows == cols) {
                    //evaluate corners
                    boolean isEqual = false;
                    State prevState = ((ToeButton) toeButtons[0]).state;
                    for (int i = 1; i < cols; i++) {
                        isEqual = prevState != State.BLANK;
                        for (int j = i; j < rows; j++) {
                            if (i != j) {
                                continue;
                            }
                            State currState = ((ToeButton) toeButtons[j + cols]).state;
                            if (prevState != currState) {
                                isEqual = false;
                            }
                            break;
                        }
                        if (!isEqual) {
                            break;
                        }
                    }
                    prevState = ((ToeButton) toeButtons[cols - 1]).state;
                    for (int i = cols - 2; i >= 0; i--) {
                        isEqual = prevState != State.BLANK;
                        for (int j = 1; j < rows; j++) {
                            if (i + j != cols - 1) {
                                continue;
                            }
                            State currState = ((ToeButton) toeButtons[i + cols * j]).state;
                            if (prevState != currState) {
                                isEqual = false;
                                break;
                            }
                        }
                        if (!isEqual) {
                            break;
                        }
                    }
                    if (isEqual) {
                        System.out.println("is equal corners");
                        return Status.WIN;
                    }
                }

                // no more moves
                for (int i = 0; i < rows * cols; i++) {
                    State currState = ((ToeButton) toeButtons[i]).state;
                    if (currState == State.BLANK) {
                        return Status.CONTINUE;
                    }
                }

                return Status.DRAW;
            }
        }
    }
}
