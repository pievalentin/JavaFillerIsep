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


    public void Start() { //une partie avec un joueur et une ia
        double maxScore = board.getSize()*board.getSize();
        over = false;
        //board.display();
        while (!over) {
            board.setStartingPoint(player1, board.getSize(), 0);
            board.setStartingPoint(IA1,0,board.getSize());
            player1.play(board);
            player1.updateScore(board);
            board.displayConsole();
            System.out.println("score de Player1 : "+player1.getScore()+"Score de l'IA : "+IA1.getScore());
            IA1.play(board);
            IA1.updateScore(board);
            board.displayConsole();

            if(player1.getScore() >= maxScore || IA1.getScore() >= maxScore )
                over=true;
            else
                over=false;



            over = isOver(board);
        }

    }

    public boolean isOver(Board board) {
        Boolean result;
        result = false;


        return result;
    }


}
