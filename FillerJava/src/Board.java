/**
 * Created by Pierre Valentin on 19/04/2016.
 */
public class Board {
    private int numberOfPlayer;
    private Token[][] tokens;
    private int size;

    public Board(int size) {
        this.size = size;
        this.tokens = new Token[size][size];
        initializeBoard();


    }

    public Token[][] getTokens() {
        return tokens;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStartingPoint(Player player, int i, int j) {
        tokens[i][j].setOwner(player);
        tokens[i][j].setPossesed(true);
    }

    public void take(Colors color, Player player) {   /* ============ Pour les carré ============ */

        //TODO eliminer les trucs du coté.

        int changeNew;
        int changeOld;

        do {
            changeNew = 0;
            //===============================================================================================

            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size; j++) {

                    if (i == 0 && j == 0) {
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            tokens[i + 1][j].eat(player, color);
                            tokens[i][j + 1].eat(player, color);

                        }
                    }

                    if (i == size - 1 && j == 0) {
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            tokens[i - 1][j].eat(player, color);
                            tokens[i][j + 1].eat(player, color);

                        }
                    }


                    if (i == 0 && j == size - 1) {
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            tokens[i][j - 1].eat(player, color);
                            tokens[i + 1][j].eat(player, color);

                        }
                    }

                    if (i == size - 1 && j == size - 1) {
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            tokens[i - 1][j].eat(player, color);
                            tokens[i][j - 1].eat(player, color);

                        }
                    }


                    if (i == 0) {
                        if (tokens[i][j].getOwner() == player) {/* ============ ligne du haut ============ */
                    /*tokens[i - 1][j].eat(player, color);*/
                            if (j != 0)
                                tokens[i][j - 1].eat(player, color);
                            if (j != size - 1)
                                tokens[i][j + 1].eat(player, color);
                            if (i != size - 1)
                                tokens[i + 1][j].eat(player, color);

                        }
                    }//fin haut


                    if (i == size - 1) {     /* ============ ligne du bas ============ */
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            if (i != 0)
                                tokens[i - 1][j].eat(player, color);
                            if (j != 0)
                                tokens[i][j - 1].eat(player, color);
                            if (j != size - 1)
                                tokens[i][j + 1].eat(player, color);
                            // tokens[i + 1][j].eat(player, color);
                        }
                    }// fin pour le bas


                    if (j == size - 1) {    /* ============ coté droit ============ */
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            if (i != 0)
                                tokens[i - 1][j].eat(player, color);
                            if (j != 0)
                                tokens[i][j - 1].eat(player, color);
                            // tokens[i][j + 1].eat(player, color);
                            if (i != size - 1)
                                tokens[i + 1][j].eat(player, color);

                        }
                    }// fin coté droit


                    if (j == 0) {   /* ============ coté gauche ============ */
                        if (tokens[i][j].getOwner() == player) {
                            tokens[i][j].setColor(color);
                            if (i != 0)
                                tokens[i - 1][j].eat(player, color);
                            // tokens[i][j - 1].eat(player, color);
                            if (j != size - 1)
                                tokens[i][j + 1].eat(player, color);
                            if (i != size - 1)
                                tokens[i + 1][j].eat(player, color);

                        }
                    }// fin coté gauche


                    //dans le centre
                    //if(0 < i < size - 1 ) {                                   /* ============ Au centre ============ */
                    if (tokens[i][j].getOwner() == player) {
                        if (i != 0)
                            tokens[i - 1][j].eat(player, color);
                        if (j != 0)
                            tokens[i][j - 1].eat(player, color);
                        if (j != size - 1)
                            tokens[i][j + 1].eat(player, color);
                        if (i != size - 1)
                            tokens[i + 1][j].eat(player, color);
                        //}
                    }
                }
            }


            //===========================================================================================
            changeOld = changeNew;
        } while (changeNew != changeOld && changeNew != 0);

    }






               /* if (tokens[i][j].getOwner() == player) {
                    tokens[i][j].setColor(color);
                    if (!tokens[i - 1][j].isPossesed() && tokens[i - 1][j].getColor() == color) {
                        tokens[i - 1][j].setColor(color);
                        tokens[i - 1][j].setPossesed(true);
                        tokens[i - 1][j].setOwner(player);
                    }
                    if (!tokens[i][j - 1].isPossesed() && tokens[i][j - 1].getColor() == color) {
                        tokens[i][j - 1].setColor(color);
                        tokens[i][j - 1].setPossesed(true);
                        tokens[i][j - 1].setOwner(player);
                    }
                    if (!tokens[i][j + 1].isPossesed() && tokens[i][j + 1].getColor() == color) {
                        tokens[i][j + 1].setColor(color);
                        tokens[i][j + 1].setPossesed(true);
                        tokens[i][j + 1].setOwner(player);
                    }
                    if (!tokens[i + 1][j].isPossesed() && tokens[i - 1][j].getColor() == color) {
                        tokens[i + 1][j].setColor(color);
                        tokens[i + 1][j].setPossesed(true);
                        tokens[i + 1][j].setOwner(player);
                    }
                }

            }
        }

    }*/

    public void initializeBoard() {
        /*   i
          j [0][0]  le premier indice définis la ligne.
            [1][0]  le deuxième définis la colone.
            [2][0]*/

        for (int i = 0; i < tokens.length; i++) {

            for (int j = 0; j < tokens.length; j++) {
                tokens[i][j] = new Token(Colors.randomColor(), false);
            }

        }

    }

    public Token[] voisin(int i, int j) {
        /**
         * @param
         *
         * i index i
         *
         *  @param
         * j index j
         *
         *
         *@return
         *              0
         *           3 i,j 1
         *              2
         *  **/


        Token[] result;
        result = new Token[3];

        try {
            result[0] = tokens[i - 1][j];
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            result[1] = tokens[i][j + 1];
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            result[2] = tokens[i + 1][j];
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            result[3] = tokens[i][j - 1];
        } catch (IndexOutOfBoundsException e) {
        }


        return result;
    }


    public void displayConsole() {


        for (int i = 0; i < tokens.length; i++) {
            System.out.println();
            for (int j = 0; j < tokens.length; j++) {
                if (!tokens[i][j].isPossesed())
                    System.out.print(Colors.colorsToString(tokens[i][j].getColor()).toLowerCase() + " ");
                else
                    System.out.print(Colors.colorsToString(tokens[i][j].getColor()) + " ");
            }

        }

    }

    public void onedisplay() {
        System.out.println(Colors.colorsToString(tokens[2][2].getColor()));
    }

    public double calculateOwnership(Player player) {
        double result = 0;
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < tokens.length; j++) {
                if (tokens[i][j].getOwner() == player)
                    result = +1;

            }
        }
        return result;
    }


}



