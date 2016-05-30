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
        if(nbIA!=nbPLayer){
            for (int i = nbPLayer - nbIA; i <= listPlayers.length; i++) {
                System.out.println("lol");
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

                //System.out.println(board.getTokens().length);
            start();
            }
        }


        else {
            for (int i = 0; i <= listPlayers.length; i++) {
                System.out.println(listPlayers.length);
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

                //System.out.println(board.getTokens().length);
                start();
            }
        }
    }


    public void start() {
        double maxScore = (board.getTokens().length * board.getTokens().length)/2;
        over = false;

        for (Player player: listPlayers
                ) {
            board.setStartingPoint(player,player.getStartI(),player.getStartJ());
            Colors startColor = board.getTokens()[player.getStartI()][player.getStartJ()].getColor();
            player.setPlayerColor(startColor);
            player.play(board,player.getPlayerColor());
            player.updateScore(board);
        }

        board.displayConsole();
        System.out.println("");

        while (!over) {
            for (Player player: listPlayers
                 ) {

                player.play(board,listPlayers);
                player.updateScore(board);
                board.displayConsole();
                System.out.println();

                for (Player key: listPlayers) {
                    System.out.println(key.getName() + " :" + key.getScore());
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
