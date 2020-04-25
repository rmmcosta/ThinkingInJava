package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

class TicTacToeButton extends JButton {
    private static final Map<Integer, String> labelCaptions = getCaptions();
    private static int lastValue = 0;

    public void restart() {
        this.currValue = 0;
        this.setCaption();
    }

    private int currValue = 0;

    private final int pos;
    private static final int MAX_VALUE = 2;

    private static Map<Integer, String> getCaptions() {
        Map<Integer, String> captions = new HashMap<>();
        captions.put(0, " ");
        captions.put(1, "X");
        captions.put(2, "O");
        return captions;
    }

    public TicTacToeButton(int pos) {
        this.pos = pos;
        setCaption();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action performed");
                currValue = lastValue == TicTacToeButton.MAX_VALUE ? 1 : 2;
                lastValue = currValue;
                setCaption();
            }
        });
    }

    public int getCurrValue() {
        return currValue;
    }

    private void setCaption() {
        System.out.println("set caption");
        this.setText(labelCaptions.get(currValue));
    }

    public int getPos() {
        return pos;
    }
}

class TicTacToeDialog extends JDialog {
    private Map<Integer, TicTacToeButton> choiceMap;
    JFrame parentFrame;
    JPanel gamePanel;

    public TicTacToeDialog(JFrame theFrame) {
        super(theFrame);
        parentFrame = theFrame;
        choiceMap = new HashMap<>();
        initGame();
    }

    private void initGame() {
        gamePanel = new JPanel(new GridLayout(3, 3));
        add(gamePanel);
        TicTacToeButton ticTacToeButton;
        for (int i = 0; i < 9; i++) {
            ticTacToeButton = new TicTacToeButton(i);
            ticTacToeButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    TicTacToeButton thisButton = (TicTacToeButton) e.getSource();
                    if (thisButton.getCurrValue() == 0) {
                        return;
                    }
                    boolean youWin = youWin(thisButton.getPos());
                    if (youWin) {
                        presentResult("You Win!");
                    } else {
                        if (gameOver()) {
                            presentResult("It's a draw!");
                        }
                    }

                }

                private void presentResult(String message) {
                    Object[] options = {"New Game", "Close"};
                    int option = JOptionPane.showOptionDialog(parentFrame,
                            message, "Result",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    System.out.println(option);
                    if (option == 0) {
                        restartGame();
                    } else {
                        System.exit(0);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            choiceMap.put(i, ticTacToeButton);
            gamePanel.add(ticTacToeButton);
        }
    }

    private void restartGame() {
        for (int i = 0; i < choiceMap.size(); i++) {
            choiceMap.get(i).restart();
        }
    }

    private boolean youWin(int currPos) {
        int choice = choiceMap.get(currPos).getCurrValue();
        if (choice == 0) {
            return false;
        }
        int[][] adjacentPositions = getAdjacentPositions(currPos);
        for (int possibility[] : adjacentPositions) {
            boolean youWin = true;
            for (int iChoice : possibility) {
                if (choiceMap.get(iChoice).getCurrValue() != choice) {
                    youWin = false;
                    break;
                }
            }
            if (youWin) {
                return true;
            }
        }
        return false;
    }

    private boolean gameOver() {
        for (int i = 0; i < choiceMap.size(); i++) {
            if (choiceMap.get(i).getCurrValue() == 0) {
                return false;
            }
        }
        return true;
    }

    private int[][] getAdjacentPositions(int currPos) {
        // middle - 8 positions
        // corners - 6 positions
        // others - 4 positions
        int[][] positions;
        switch (currPos) {
            case 4:
                positions = new int[4][2];
                positions[0] = new int[]{0, 8};
                positions[1] = new int[]{2, 6};
                positions[2] = new int[]{1, 7};
                positions[3] = new int[]{3, 5};
                return positions;
            case 0:
                positions = new int[3][2];
                positions[0] = new int[]{1, 2};
                positions[1] = new int[]{3, 6};
                positions[2] = new int[]{4, 8};
                return positions;
            case 2:
                positions = new int[3][2];
                positions[0] = new int[]{0, 1};
                positions[1] = new int[]{5, 8};
                positions[2] = new int[]{4, 6};
                return positions;
            case 6:
                positions = new int[3][2];
                positions[0] = new int[]{0, 3};
                positions[1] = new int[]{4, 2};
                positions[2] = new int[]{7, 8};
                return positions;
            case 8:
                positions = new int[3][2];
                positions[0] = new int[]{5, 2};
                positions[1] = new int[]{4, 0};
                positions[2] = new int[]{7, 6};
                return positions;
            case 1:
                positions = new int[2][2];
                positions[0] = new int[]{0, 2};
                positions[1] = new int[]{4, 7};
                return positions;
            case 3:
                positions = new int[2][2];
                positions[0] = new int[]{0, 6};
                positions[1] = new int[]{4, 5};
                return positions;
            case 5:
                positions = new int[2][2];
                positions[0] = new int[]{8, 2};
                positions[1] = new int[]{4, 3};
                return positions;
            case 7:
                positions = new int[2][2];
                positions[0] = new int[]{6, 8};
                positions[1] = new int[]{4, 1};
                return positions;
            default:
                positions = new int[0][0];
                return positions;
        }
    }
}

class TicTacToeMain extends JFrame {
    JMenuBar menuBar;
    JMenu menu;

    private void initializeMenu(JFrame theFrame) {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeDialog gameWindow = new TicTacToeDialog(theFrame);
                gameWindow.setMinimumSize(new Dimension(200, 200));
                gameWindow.setLocationRelativeTo(theFrame);
                gameWindow.setTitle("New Game");
                gameWindow.setVisible(true);
            }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(newGame);
        menu.add(exit);
    }

    public TicTacToeMain() throws HeadlessException {
        initializeMenu(this);
    }
}

public class MyTicTacToe {
    public static void main(String[] args) {
        SwingConsole.runFrame(new TicTacToeMain());
    }
}
