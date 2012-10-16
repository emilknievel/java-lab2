package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTest {
    public static void main(String[] args) {

        final Board board = new Board(20, 10);
        final TetrisFrame gameFrame = new TetrisFrame(board);

        final Action doOneStep = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                // Gå ett steg i spelet!
                if (!board.fail()) {
                    board.tick();
                } else {
                    System.exit(0);
                }
            }
        };

        final Timer clockTimer = new Timer(300, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();
    }

    // Board functions:
    // -----------------------------------------------------------------------
    /*public static SquareColor randomSquareColor() {
        int randomNo = new Random().nextInt(4);
        if (randomNo != 3) {
            return SquareColor.values()[randomNo];
        } else return null;
    }

    public static void addRandomSquareColors(Board obj) {
        for (int r = 0; r < obj.getRows(); r++) {
            for (int c = 0; c < obj.getColumns(); c++) {
                obj.addSquareColor(r, c, randomSquareColor());
            }
        }
        obj.update();
    }*/
    // -----------------------------------------------------------------------

}
