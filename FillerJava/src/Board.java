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
        tokens[i][j].setPossessed(true);
    }

    public void take(Colors color, Player player) {   /* ============ Pour les carrés ============ */

        //TODO eliminer les trucs du coté.


        boolean modification;
        modification = true;

        while (modification) {

            modification = false;

            for (int i = 0; i < size; i++) {

                for (int j = 0; j < size; j++) {

                    if (tokens[i][j].getOwner() == player) {
                        tokens[i][j].setColor(color);
                        if (i != 0)
                            modification = (tokens[i - 1][j].eat(player, color) || modification);
                        if (j != 0)
                            modification = (tokens[i][j - 1].eat(player, color) || modification);
                        if (j != size - 1)
                            modification = (tokens[i][j + 1].eat(player, color) || modification);
                        if (i != size - 1)
                            modification = (tokens[i + 1][j].eat(player, color) || modification);
                        //}
                    }
                }
            }




        }

    }


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


    public void displayConsole() {


        for (int i = 0; i < tokens.length; i++) {
            System.out.println();
            for (int j = 0; j < tokens.length; j++) {
                if (!tokens[i][j].isPossessed())
                    System.out.print(Colors.colorsToString(tokens[i][j].getColor()).toLowerCase() + " ");
                else
                    System.out.print(Colors.colorsToString(tokens[i][j].getColor()) + " ");
            }

        }

    }

    public void graphicDisplay(){
        double coteCarre = (0.7 / tokens.length) / 2;
        double x = 0.02;
        double y = 1-0.02;
        for (int i = 0; i < tokens.length; i++) {
            y = y - coteCarre*2;
            x = 0.02;
            for (int j = 0; j < tokens.length; j++) {
                StdDraw.setPenColor(Colors.colorsToColor(tokens[i][j].getColor()));
                StdDraw.filledSquare(x,y,coteCarre);
                x = x+coteCarre*2;

            }

        }


    }



    public int calculateOwnership(Player player) {
        int result = 0;

        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                if (tokens[i][j].getOwner() == player)
                    result = result + 1;

            }
        }
        return result;
    }

    /*public void onedisplay() {
        System.out.println(Colors.colorsToString(tokens[2][2].getColor()));
    }*/


}



