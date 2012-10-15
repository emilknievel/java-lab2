package se.liu.ida.emiva760.tddc69.lab2;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private  int rows = 20;
    private  int columns = 10;
    private final ArrayList<BoardListener> BoardListenerList = new ArrayList<BoardListener>();

    private static Random randomNo = new Random();
    private int polyTypes = randomNo.nextInt(TetrominoMaker.getNumberOfTypes());

    private SquareColor[][] array = new SquareColor[20][10];

    private Poly poly = TetrominoMaker.getPoly(polyTypes);

    private int polyYCoord = 0;
    private int polyXCoord = getColumns()/2 - polyWidth()/2;

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

    // Is there a polyomino?
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

    public void addBoardListener(BoardListener bl) {
        BoardListenerList.add(bl);
    }

    private void notifyListeners() {
        for (BoardListener bl : BoardListenerList) {
            bl.boardChanged();
        }
    }

    public void update() {
        notifyListeners();
    }

    public void tick() {
        if (poly != null && (!reachedBottom() && !collidesUnder())) {
            moveDown();
        } else {
            convertToSquareColors();
            int randomType = randomNo.nextInt(TetrominoMaker.getNumberOfTypes());
            poly = TetrominoMaker.getPoly(randomType);
            polyYCoord = 0;
            polyXCoord = getColumns()/2 - polyWidth()/2;
            removeFullRow();
            notifyListeners();
        }
    }

    private void moveDown() {
        polyYCoord++;
        notifyListeners();
    }

    public void moveLeft() {
        if (polyXCoord > 0) {
            polyXCoord--;
            notifyListeners();
        }
    }

    public void moveRight() {
        if (polyXCoord + polySquaresWidth() < columns) {
            polyXCoord++;
            notifyListeners();
        }
    }

    private boolean reachedBottom() {
        return (polyYCoord + polyHeight()) == rows;
    }

    // Convert the poly to SquareColors and delete it
    private void convertToSquareColors() {
        for (int i = polyYCoord; i < polyYCoord + polyHeight(); i++) {
            for (int j = polyXCoord; j < polyXCoord + polyWidth(); j++) {
                if (getFallingSquareColor(i, j) != null) {
                    array[i][j] = getFallingSquareColor(i, j);
                }
            }
        }
        poly = null;
    }

    // Game over if the new poly collides with a SquareColor at the "spawn"
    public boolean fail() {
        for (int i = 0; i < polyHeight(); i++) {
            for (int j = 0; j < polyWidth(); j++) {
                if (getSquareColor(i, j) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean polyCollides(int yDiff, int xDiff) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // Check the next position for collisions
                if(getSquareColor(row, column) != null &&
                    existPoly(row - yDiff, column - xDiff) &&
                    getFallingSquareColor(row - yDiff, column - xDiff) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collidesUnder() {
        return polyCollides(1, 0);
    }

    public boolean collidesLeft() {
        return polyCollides(0, -1);
    }

    public boolean collidesRight() {
        return polyCollides(0, 1);
    }

    // The actual "physical" width of the falling poly
    private int polySquaresWidth() {
        for (int i = polyWidth() - 1; i > 0; i--) {
            for (int j = 0; j < polyHeight(); j++) {
                if (getFallingSquareColor(j + polyYCoord , i + polyXCoord) != null) {
                    return i + 1;
                }
            }
        }
        return 1;
    }

    // Checks whether the row is filled
    private boolean fullRow(int row) {
        boolean full = true;
        for (int j = 0; j < columns; j++) {
            if (array[row][j] == null) {
                full = false;
            }
        }
       return full;
    }

    private void removeFullRow() {
        for (int i = rows - 1; i > 0; i--) {
            if (fullRow(i)) {
                replaceRow(i);
            }
        }
    }

    // replaces the row with the one above it
    private void replaceRow(int row) {
        int i = row;
        while (i > 0) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = array[i - 1][j];
            }
            i--;
        }
    }
}