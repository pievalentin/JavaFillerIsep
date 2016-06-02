public class Party {

    private int numberOfPlayer;
    private int numberOfIA;
    private int totalOfPlayer;
    private int sizeBoard;
    private Player[] listAllPlayers;
    private Player[] listPlayers;
    private IA[] listIA;
    private Board board;
    private Boolean over;
    private Player winner;

    public Party(int sizeBoard,int nbPLayer, int nbIA) {
        this.numberOfPlayer=nbPLayer;
        this.numberOfIA = nbIA;
        this.totalOfPlayer=nbIA+nbPLayer;
        this.sizeBoard=sizeBoard;
        board = new Board(sizeBoard);

        listPlayers = new Player[nbPLayer];
        listIA = new IA[numberOfIA];
        listAllPlayers = new Player[numberOfPlayer+numberOfIA];

        int indexStarter = nbPLayer*2;

        int[] locationStater = {(sizeBoard-1),(0),(0),(sizeBoard - 1), (0), (0), (sizeBoard - 1), (sizeBoard - 1)};

        int yes =0 ;
        for (int i = 0; i <numberOfPlayer ; i++,yes=yes+2) {

            listPlayers[i] = new Player(locationStater[yes],locationStater[yes+1]);
            listPlayers[i].setName("player "+i);

        }



        for (int i = 0; i < numberOfIA; i++,indexStarter=indexStarter+2) {
            listIA[i] = new IA(locationStater[indexStarter],locationStater[indexStarter+1]);
            listIA[i].setName("IA "+i);
           // indexStarter++;
        }


        //System.out.println(listIA[0].getStartJ());



        start();
    }


    public void start() {
        double maxScore = (board.getTokens().length * board.getTokens().length)/2;
        over = false;

        if(numberOfPlayer!=0){
        for (Player player: listPlayers
                ) {
            starter(player,board);
        }}

        if (numberOfIA!=0){
        for (IA ia: listIA
             ) {
            starter(ia,board);
        }}

        board.displayConsole();
        System.out.println("");

//        for (Colors color: availableColors(listIA,listPlayers,totalOfPlayer)
//             ) {
//            System.out.println(Colors.colorsToString(color));
//
//        }

        while (!over) {

            if(numberOfPlayer!=0){
                for (Player player: listPlayers
                     ) {
                    player.play(board,listPlayers,listIA,totalOfPlayer,this);
                    player.updateScore(board);
                    board.displayConsole();
                    System.out.println();
                    //affichage des scores
                    System.out.println();
                    if(numberOfPlayer!=0){
                        for (Player key1: listPlayers) {
                            System.out.println("Score de "+key1.getName() + " :" + key1.getScore());
                            if (key1.getScore() >= maxScore) {
                                over = true;
                                isOver(player);
                                break;}
                        }
                    }
                    if (numberOfIA!=0){
                        for (IA key2: listIA
                             ) {
                            System.out.println(key2.getName() + " :" + key2.getScore());
                            if (key2.getScore() >= maxScore) {
                                over = true;
                                isOver(player);
                                break;}
                        }
                    }


                //for (Player player : listPlayers) {
                    if (player.getScore() >= maxScore) {
                        over = true;
                        isOver(player);
                        break;}
                    //}


                }
            }

            if (numberOfIA!=0){
                for (IA ia: listIA
                        ) {
                    ia.playIA(board,listPlayers,listIA,totalOfPlayer,this);
                    ia.updateScore(board);
                    board.displayConsole();
                    System.out.println();
                    //affichage des scores
                    for (Player key1: listPlayers) {
                        System.out.println(key1.getName() + " :" + key1.getScore());
                    }
                    for (IA key2: listIA
                            ) {
                        System.out.println(key2.getName() + " :" + key2.getScore());
                    }

                    if (ia.getScore() >= maxScore) {
                        over = true;
                        isOver(ia);
                        break;
                    }

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
        Runtime.getRuntime().exit(1);
    }


    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void starter(Player player, Board board){

        board.setStartingPoint(player,player.getStartI(),player.getStartJ());
        Colors startColor = board.getTokens()[player.getStartI()][player.getStartJ()].getColor();
        player.setPlayerColor(startColor);
        player.play(board, player.getPlayerColor());
        player.updateScore(board);

    }

    public Player[] getListAllPlayers() {
        return listAllPlayers;
    }

    public Colors[] availableColors(IA[] listIA, Player[] listPlayer, int nbTotalPlayer){
        Colors[] result = new Colors[6-nbTotalPlayer+1];
        int i = 0;
        for (Colors colors:Colors.values()
             ) {
            boolean toAdd = true;
            for (Player player:listPlayer
                 ) {
                if(player.getPlayerColor()==colors)
                    toAdd=false;

            }

            for (IA ia:listIA
                 ) {
                if(ia.getPlayerColor()==colors)
                    toAdd=false;

            }

            if(toAdd){
                result[i]=colors;
                i++;
            }
        }

    return result;

    }

    public int getTotalOfPlayer() {
        return totalOfPlayer;
    }
}
