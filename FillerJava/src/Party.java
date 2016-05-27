public class Party {
    int numberOfPlayer;

    Player[] listPlayers;
    Board board;
    Boolean over;
    Player winner;

    public Party(int sizeBoard,int nbPLayer, int nbIA) {
        for (int i = 0; i <nbPLayer-nbIA ; i++) {

            if (i == 0) {
                System.out.println(listPlayers[i]);
                listPlayers[i] = new Player(sizeBoard, 0);
                listPlayers[i].setName("player" + i);
            }
            if (i == 1) {
                listPlayers[i]= new Player(0,sizeBoard);
                listPlayers[i].setName("player" + i);
            }
            if (i == 2) {
                listPlayers[i]= new Player(0,0);
                listPlayers[i].setName("player" + i);
            }
            if (i == 3) {
                listPlayers[i]= new Player(sizeBoard,sizeBoard);
                listPlayers[i].setName("player" + i);
            }

        }

        for (int i = nbPLayer - nbIA; i <= listPlayers.length; i++) {
            if (i == 0) {
                listPlayers[i] = new IA(sizeBoard, 0);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 1) {
                listPlayers[i]= new Player(0,sizeBoard);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 2) {
                listPlayers[i]= new Player(0,0);
                listPlayers[i].setName("IA" + i);
            }
            if (i == 3) {
                listPlayers[i]= new Player(sizeBoard,sizeBoard);
                listPlayers[i].setName("IA" + i);
            }
        board.setSize(sizeBoard);
        board.initializeBoard();
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

        while (!over) {
            for (Player player: listPlayers
                 ) {

                player.play(board);
                player.updateScore(board);
                board.displayConsole();

                for (int i = 0; i < listPlayers.length; i++) {
                    System.out.println("score de player" + i + ": " + player.getScore());

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
