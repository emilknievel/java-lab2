package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisFrame extends JFrame {

    private Board board;
    private JTextArea textArea;

    // Constructor
    public TetrisFrame(Board board) {
        super("Game board");
        this.board = board;

        createGUI();
        createMenu();
        textArea.setEditable(false);
        insertText();

        pack(); // adapts the size of the window
        setVisible(true); // shows the window
    }

    private void createGUI() {
        setLayout(new BorderLayout());
        this.textArea = new JTextArea(board.getRows(), board.getColumns());

        add(this.textArea, BorderLayout.CENTER);
    }

    private void insertText() {
        textArea.setText(TextViewer.convertToText(board));
    }

    public void updateText() {
        insertText();
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
