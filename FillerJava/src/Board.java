/**
 * Created by Pierre Valentin on 19/04/2016.
 */
public class Board {
    private int numberOfPlayer;
    private Token[][] tokens;
    private int size;

    public Token[][] getTokens() {
        return tokens;
    }

    public Board(int size) {
        this.size = size;
        this.tokens = new Token[size][size];
        initializeBoard();


    }

    public void setStartingPoint(Player player, int i, int j) {
        tokens[i][j].setOwner(player);
        tokens[i][j].setPossesed(true);

    }

    public void take(Colors color, Player player) {
        for (int i = 0; i < getTokens().length; i++) {

            for (int j = 0; j < getTokens().length; j++) {
                if (tokens[i][j].getOwner() == player) {
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

    }

    public void initializeBoard() {

        /*[0][0]  le premier indice définis la ligne.
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
