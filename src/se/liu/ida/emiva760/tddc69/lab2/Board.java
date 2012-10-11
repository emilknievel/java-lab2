package se.liu.ida.emiva760.tddc69.lab2;

import java.util.Random;

public class Board {
    private int rows = 20;
    private int columns = 10;

    private int polyTypes = new Random().nextInt(TetrominoMaker.getNumberOfTypes());

    private SquareColor[][] array = new SquareColor[20][10];

    private Poly poly = TetrominoMaker.getPoly(polyTypes);
    private int polyYCoord = new Random().nextInt(getRows() - polyHeight());
    private int polyXCoord = new Random().nextInt(getColumns() - polyWidth());

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int polyWidth() {
        return poly.getWidth();
    }
    public int polyHeight() {
        return poly.getHeight();
    }

    public SquareColor getSquareColor(int row, int column) {
        return array[row][column];
    }

    public void addSquareColor(int row, int column, SquareColor color) {
        array[row][column] = color;
    }

    public SquareColor[][] getPolySquares() {
        return poly.getPolySquares();
    }

    public boolean existPoly(int row, int column) {
        // Check collision with "bounding box"
        if ((column > polyXCoord + polyWidth() - 1)     ||
            (row > polyYCoord + polyHeight() - 1)       ||
            (polyXCoord > column)                       ||
            (polyYCoord > row)) {
            return false;
        }
        return true;
    }

    public SquareColor getFallingSquareColor(int row, int column) {
            return getPolySquares()[row - polyYCoord][column - polyXCoord];
    }
}
