/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Party {
    int numberOfPlayer;

    Player player1;
    Player player2;
    Player player3;
    Player player4;
    IA IA1;
    IA IA2;
    Board board;


    Boolean over;
    String winner;

    public Party() {

    }


    public void Start(Party party) { //une partie avec un joueur et une ia

        over = false;
        //board.display();
        while (over) {
            player1.play(board);
            //IA.play(board);
            over = isOver(board);
        }

    }

    public boolean isOver(Board board) {
        Boolean result;
        result = false;


        return result;
    }


}
