package se.liu.ida.emiva760.tddc69.lab2;

import javax.swing.*;
import java.awt.*;

public class TetrisFrame extends JFrame {

    private Board board;
    private JTextArea textArea;

    // Constructor
    public TetrisFrame(Board board) {
        super("Game board");
        this.board = board;

        createGUI();
        textArea.setEditable(false);
        insertText();

        pack(); // adapts the size of the window
        setVisible(true); // shows the window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // close the application
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
}