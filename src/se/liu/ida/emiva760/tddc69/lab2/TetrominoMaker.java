package se.liu.ida.emiva760.tddc69.lab2;

public class TetrominoMaker {
    // Returns the number of types.
    public static int getNumberOfTypes() {
        return 7;
    }

    // What type of polyomino do we want to create?
    public static Poly getPoly(int n) {
        return new Poly(TetrominoBuilder(n), 4, 4);
    }

    // TODO: Perhaps create the figures on the top-left corner instead?
    // Creates a SquareColor array
    public static SquareColor[][] TetrominoBuilder(int type) {

        SquareColor[][] tet = new SquareColor[4][4];

        switch (type) {
            case 0:
                /*
                  #
                  #
                  #
                  #
                */
                makeTet1(tet);
                break;
            case 1:
                /*


                  ##
                  ##
                */
                makeTet2(tet);
                break;
            case 2:
                /*

                  #
                  #
                  ##
                */
                makeTet3(tet);
                break;
            case 3:
                /*

                   #
                   #
                  ##
                */
                makeTet4(tet);
                break;
            case 4:
                /*


                   #
                  ###
                */
                makeTet5(tet);
                break;
            case 5:
                /*

                  #
                  ##
                   #
                */
                makeTet6(tet);
                break;
            case 6:
                /*

                   #
                  ##
                  #
                */
                makeTet7(tet);
                break;
        }

        return tet;
    }

    private static void makeTet1(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    tet[i][j] = SquareColor.YELLOW;
                } else tet[i][j] = null;
            }
        }
    }

    private static void makeTet2(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == 2 || i == 3) && (j == 0 || j == 1)) {
                    tet[i][j] = SquareColor.BLUE;
                } else tet [i][j] = null;
            }
        }
    }

    private static void makeTet3(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (((i == 1 || i == 2) && j == 0) || (i == 3 && (j == 0 || j == 1))) {
                    tet[i][j] = SquareColor.RED;
                } else tet [i][j] = null;
            }
        }
    }

    private static void makeTet4(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (((i == 1 || i == 2) && j == 1) || (i == 3 && (j == 0 || j == 1))) {
                    tet[i][j] = SquareColor.YELLOW;
                } else tet [i][j] = null;
            }
        }
    }

    private static void makeTet5(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == 2 && j == 1) || (i == 3 && (j == 0 || j == 1 || j == 2))) {
                    tet[i][j] = SquareColor.BLUE;
                } else tet[i][j] = null;
            }
        }
    }

    private static void makeTet6(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (((i == 1 || i == 2) && j == 0) || ((i == 2 || i == 3) && j == 1)) {
                    tet[i][j] = SquareColor.RED;
                } else tet[i][j] = null;
            }
        }
    }

    private static void makeTet7(SquareColor[][] tet) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (((i == 1 || i == 2) && j == 1) || ((i == 2 || i == 3) && j == 0)) {
                    tet[i][j] = SquareColor.YELLOW;
                } else tet[i][j] = null;
            }
        }
    }
}
