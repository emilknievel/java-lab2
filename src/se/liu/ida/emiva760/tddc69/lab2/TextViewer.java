package se.liu.ida.emiva760.tddc69.lab2;

public class TextViewer {
    static String colorToSymbol(SquareColor color) {
        String colorSymbol;
        if (color != null) {
            switch (color) {
                case RED:
                    colorSymbol = "r";
                    break;
                case BLUE:
                    colorSymbol = "b";
                    break;
                case YELLOW:
                    colorSymbol = "y";
                    break;
                default:
                    colorSymbol = " ";
                    break;
            }
        } else colorSymbol = " ";
        return colorSymbol;
    }

    public static String convertToText(Board board) {
        StringBuilder sb = new StringBuilder();
        String textView = "\n";
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.existPoly(i, j) && board.getFallingSquareColor(i, j) != null) {
                    sb = sb.append(colorToSymbol(board.getFallingSquareColor(i, j)));
                } else sb = sb.append(colorToSymbol(board.getSquareColor(i, j)));
            }
            sb.append("\n");
        }
        textView = sb.toString();
        return textView;
    }
}
