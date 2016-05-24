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

    public Party(int sizeBoard) {
        board.setSize(sizeBoard);
        board.initializeBoard();
        start();
    }


    public void start() { //une partie avec un joueur et une IA
        double maxScore = board.getSize()*board.getSize();
        over = false;
        player1.setStartI(board.getSize()); player1.setStartJ(0);
        IA1.setStartI(0); IA1.setStartJ(board.getSize());


        while (!over) {

            board.setStartingPoint(player1, player1.getStartI(), player1.getStartJ());
            board.setStartingPoint(IA1,IA1.getStartI(),IA1.getStartJ());
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
