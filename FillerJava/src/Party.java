public class Party {
    int numberOfPlayer;
    Player[] listPlayers;
    Board board;
    Boolean over;
    Player winner;

    public Party(int sizeBoard,int nbPLayer, int nbIA) {

        board = new Board(sizeBoard);

        listPlayers = new Player[nbPLayer];

        for (int i = 0; i <nbPLayer-nbIA ; i++) {

            if (i == 0) {
                listPlayers[i] = new Player(sizeBoard - 1, 0);
                listPlayers[i].setName("player" + i);
            }
            if (i == 1) {
                listPlayers[i] = new Player(0, sizeBoard - 1);
                listPlayers[i].setName("player" + i);
            }
            if (i == 2) {

                listPlayers[i]= new Player(0,0);
                listPlayers[i].setName("player" + i);
            }

            if (i == 3) {
                listPlayers[i] = new Player(sizeBoard - 1, sizeBoard - 1);
                listPlayers[i].setName("player" + i);
            }

        }

        for (int i = nbPLayer - nbIA; i <= listPlayers.length; i++) {
            if (i == 0) {
                listPlayers[i] = new IA(sizeBoard - 1, 0);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 1) {
                listPlayers[i] = new Player(0, sizeBoard - 1);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 2) {
                listPlayers[i]= new Player(0,0);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 3) {
                listPlayers[i] = new Player(sizeBoard - 1, sizeBoard - 1);
                listPlayers[i].setName("IA" + i);
            }
        board.initializeBoard();
            System.out.println(board.getTokens().length);
        start();
        }
    }


    public void start() { //une partie avec un joueur et une IA
        double maxScore = board.getSize()*board.getSize();
        over = false;

        for (Player player: listPlayers
                ) {
            board.setStartingPoint(player,player.getStartI(),player.getStartJ());

        }

        board.displayConsole();
        System.out.println("");

        while (!over) {
            for (Player player: listPlayers
                 ) {

                player.play(board);
                player.updateScore(board);
                board.displayConsole();

                for (Player key: listPlayers) {
                    System.out.println("score de player: " + key.getScore());
                }
            }

            for (Player player : listPlayers) {
                if (player.getScore() >= maxScore) {
                    over = true;
                    isOver(player);
                    break;
                } else
                    over = false;




        }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void isOver(Player player) {
        winner = player;
        System.out.println("le gagnat est : " + winner.getName());
    }


}
