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

    public static void take(Colors color, Player player) {

    }

    private void initializeBoard() {

        for (int i = 0; i < tokens.length; i++) {

            for (int j = 0; j < tokens.length; j++) {
                tokens[i][j] = new Token(Colors.randomColor(), false);
            }

        }

    }

    public void displayConsole() {


        for (int i = 0; i < tokens.length; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
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


}
