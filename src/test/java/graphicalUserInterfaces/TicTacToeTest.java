package graphicalUserInterfaces;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe.ToeDialog toeDialog;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testEvaluateStatus() {
        Component[] components = new Component[9];
        for (int i = 0; i < 9; i++) {
            TicTacToe.ToeDialog.ToeButton toeButton = toeDialog.getNewToeButton();
            if(i==0||i==1||i==2)
                toeButton.state = TicTacToe.State.X;
            components[i] = toeButton;
        }
        TicTacToe.Status result = toeDialog.evaluateStatus(components, 3, 3);
        assertEquals(TicTacToe.Status.WIN,result);
    }
}