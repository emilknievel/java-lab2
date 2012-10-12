package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.*;

public class GraphicalViewer extends JComponent {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 700;

    private final Board board;

    public GraphicalViewer(Board board) {
        this.board = board;
    }

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

}
