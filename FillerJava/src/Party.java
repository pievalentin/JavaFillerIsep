public class Party {
    int numberOfPlayer;
    int numberOfIA;
    Player[] listPlayers;
    IA[] listIA;
    Board board;
    Boolean over;
    Player winner;

    public Party(int sizeBoard,int nbPLayer, int nbIA) {
        this.numberOfPlayer=nbPLayer;
        this.numberOfIA = nbIA;
        board = new Board(sizeBoard);

        listPlayers = new Player[nbPLayer];

        for (int i = 0; i <numberOfPlayer ; i++) {

            if (i == 0) {
                listPlayers[i] = new Player(sizeBoard - 1, 0);
                listPlayers[i].setName("player 1");
            }
            if (i == 1) {
                listPlayers[i] = new Player(0, sizeBoard - 1);
                listPlayers[i].setName("player 2");
            }
            if (i == 2) {

                listPlayers[i]= new Player(0,0);
                listPlayers[i].setName("player 3");
            }

            if (i == 3) {
                listPlayers[i] = new Player(sizeBoard - 1, sizeBoard - 1);
                listPlayers[i].setName("player 4");
            }

        }

            for (int i = 0; i < listPlayers.length; i++) {
                if (i == 0) {
                    listPlayers[i] = new IA(sizeBoard - 1, 0);
                    listPlayers[i].setName("IA 1");
                }
                if (i == 1) {
                    listPlayers[i] = new Player(0, sizeBoard - 1);
                    listPlayers[i].setName("IA 2");
                }
                if (i == 2) {
                    listPlayers[i]= new Player(0,0);
                    listPlayers[i].setName("IA 3");
                }
                if (i == 3) {
                    listPlayers[i] = new Player(sizeBoard - 1, sizeBoard - 1);
                    listPlayers[i].setName("IA 4");
                }
            }
        start();
            }


    public void start() {
        double maxScore = (board.getTokens().length * board.getTokens().length)/2;
        over = false;

        for (Player player: listPlayers
                ) {
            board.setStartingPoint(player,player.getStartI(),player.getStartJ());
            Colors startColor = board.getTokens()[player.getStartI()][player.getStartJ()].getColor();
            player.setPlayerColor(startColor);
            player.play(board, player.getPlayerColor());
            player.updateScore(board);
        }

        board.displayConsole();
        System.out.println("");

        while (!over) {
            for (Player key: listPlayers
                 ) {
                if(key instanceof IA){
                    System.out.println("l'ia joue");
                    key.playIA(board,listPlayers,numberOfPlayer);}


                key.play(board,listPlayers);
                key.updateScore(board);
                board.displayConsole();
                System.out.println();

                for (Player key1: listPlayers) {
                    System.out.println(key1.getName() + " :" + key1.getScore());
                }


            //for (Player player : listPlayers) {
                if (key.getScore() >= maxScore) {
                    over = true;
                    isOver(key);
                    break;
                //}
            }

            }
        }
    }

            /*try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/



    public void isOver(Player player) {
        winner = player;
        System.out.println("le gagnant est : " + winner.getName());
    }


    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public Player[] getListPlayers() {
        return listPlayers;
    }
}
