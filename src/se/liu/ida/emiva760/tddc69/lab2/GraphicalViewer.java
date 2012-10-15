package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.*;

public class GraphicalViewer extends JComponent implements BoardListener {
    private static final int WIDTH = 330;
    private static final int HEIGHT = 660;
    private static final int BLOCKWIDTH = WIDTH/10;
    private static final int BLOCKHEIGHT = HEIGHT/20;

    private final Board board;

    public GraphicalViewer(Board board) {
        this.board = board;
        board.addBoardListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void paintComponent(final Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;
        paintBackground(g2);
        paintBlocks(g2);
    }

    public void paintBackground(final Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(0, 0, WIDTH, HEIGHT));
    }

    // If there is a poly, paint it. Otherwise paint the static blocks
    public void paintBlocks(final Graphics2D g2) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.existPoly(i, j) && board.getFallingSquareColor(i, j) != null) {
                    g2.setColor(convertToColor(board.getFallingSquareColor(i, j)));
                    int blockY = i*BLOCKHEIGHT;
                    int blockX = j*BLOCKWIDTH;
                    g2.fill(new Rectangle(blockX, blockY, BLOCKWIDTH, BLOCKHEIGHT));
                } else {
                    g2.setColor(convertToColor(board.getSquareColor(i, j)));
                    int blockY = i*BLOCKHEIGHT;
                    int blockX = j*BLOCKWIDTH;
                    g2.fill(new Rectangle(blockX, blockY, BLOCKWIDTH, BLOCKHEIGHT));
                }
            }
        }
    }

    // How to know what color to draw for every SquareColor
    public Color convertToColor(SquareColor c) {
        if(c == null) return Color.BLACK;
        else
        switch (c) {
            case BLUE:
                return Color.BLUE;
            case RED:
                return Color.RED;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }

    }

    public void boardChanged() {
        this.repaint();
    }
}
