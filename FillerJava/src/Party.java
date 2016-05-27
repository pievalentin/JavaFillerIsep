/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Party {
    int numberOfPlayer;

    Player[] listPlayers;
    Board board;
    Boolean over;
    Player winner;

    public Party(int sizeBoard,int nbPLayer, int nbIA) {
        for (int i = 0; i <nbPLayer-nbIA ; i++) {

            if (i==0)
                listPlayers[i]= new Player(sizeBoard,0);
            if(i==1)
                listPlayers[i]= new Player(0,sizeBoard);
            if(i==2)
                listPlayers[i]= new Player(0,0);
            if(i==3)
                listPlayers[i]= new Player(sizeBoard,sizeBoard);


        }

        for (int i = nbPLayer-nbIA; i <=4 ; i++) {
            if (i==0)
                listPlayers[i]= new IA(sizeBoard,0);
            if(i==1)
                listPlayers[i]= new Player(0,sizeBoard);
            if(i==2)
                listPlayers[i]= new Player(0,0);
            if(i==3)
                listPlayers[i]= new Player(sizeBoard,sizeBoard);

        }
        board.setSize(sizeBoard);
        board.initializeBoard();
        start();
    }


    public void start() { //une partie avec un joueur et une IA
        double maxScore = board.getSize()*board.getSize();
        over = false;

        for (Player player: listPlayers
                ) {
            board.setStartingPoint(player,player.getStartI(),player.getStartJ());

        }

        while (!over) {
            for (Player player: listPlayers
                 ) {

                player.play(board);
                player.updateScore(board);

            }

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
