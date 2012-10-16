package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisFrame extends JFrame {

    private final Board board;
    private GraphicalViewer graphics;

    // Constructor
    public TetrisFrame(final Board board) {
        super("Game board");
        this.board = board;

        createGUI();
        createMenu();

        pack(); // adapts the size of the window
        setVisible(true); // shows the window

        final Action goLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!board.collidesLeft()) {
                    board.moveLeft();
                }
            }
        };

        final Action goRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!board.collidesRight()) {
                    board.moveRight();
                }
            }
        };

        // Get input from the keyboard and the action to be used
        graphics.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "goLeft");
        graphics.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "goRight");
        graphics.getActionMap().put("goLeft", goLeft);
        graphics.getActionMap().put("goRight", goRight);
    }

    private void createGUI() {
    setLayout(new BorderLayout());
        graphics = new GraphicalViewer(this.board);
        add(graphics, BorderLayout.CENTER);
        graphics.repaint();
    }

    private void createMenu() {
        final JMenu menu = new JMenu("Menu");

        final JMenuItem exit = new JMenuItem("Exit");
        menu.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask for confirmation
                int confirmExit = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "User Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        final JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
    }

}
