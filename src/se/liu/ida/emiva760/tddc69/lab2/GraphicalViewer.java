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

    public void paintComponent(final Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;
        paintBackground(g2);
        //paintPlacedBlock(g2);
        //paintFallingBlock(g2);
    }

    public void paintBackground(final Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle(0, 0, WIDTH, HEIGHT));
    }

    public void paintPlacedBlock(final Graphics2D g2) {

    }

    public void paintFallingBlock(final Graphics2D g2) {

    }

    // How to know what color to draw for every SquareColor
    public Color convertToColor(SquareColor c) {
        switch (c) {
            case BLUE:
                return Color.BLUE;
            case RED:
                return Color.RED;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }
}
