package se.liu.ida.emiva760.tddc69.lab2;

public class Poly {
    private int width;
    private int height;
    private SquareColor[][] poly;

    public Poly(SquareColor[][] blockArray, int width, int height) {
        this.width = width;
        this.height = height;
        this.poly = blockArray;
    }

    public SquareColor[][] getPolySquares() {
        return poly;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
