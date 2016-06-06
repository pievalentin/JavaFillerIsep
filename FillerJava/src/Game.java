import java.awt.*;

public class Game {

    private int numberOfPlayer;
    private int numberOfIA;
    private int totalOfPlayer;
    private int sizeBoard;
    private int turnNumber;
    private Player[] listAllPlayers;
    private Player[] listPlayers;
    private IA[] listIA;
    private Board board;
    private Boolean over;
    private Player winner;

    public Game(int sizeBoard, int nbPLayer, int nbIA, boolean graphic) {
        Font font = new Font("Helvetica", 1, 18);
        StdDraw.setFont(font);
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


        if (!graphic)
            start();

        if (graphic)
            startGraphic();
    }



    public Game(){
        Font font = new Font("Helvetica", 1, 18);
        StdDraw.setFont(font);
        this.numberOfPlayer=askNumberOfPlayer();
        this.numberOfIA = askNumberOfIA();
        this.totalOfPlayer=numberOfIA+numberOfPlayer;
        this.sizeBoard=askSizeBoard();
        board = new Board(sizeBoard);

        listPlayers = new Player[numberOfPlayer];
        listIA = new IA[numberOfIA];
        listAllPlayers = new Player[totalOfPlayer];

        int indexStarter = numberOfPlayer*2;

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

            StdDraw.clear();
            startGraphic();
    }

    private void startGraphic() {

        double maxScore = (board.getTokens().length * board.getTokens().length) / totalOfPlayer;
        over = false;

        if (numberOfPlayer != 0) {
            for (Player player : listPlayers
                    ) {
                starter(player, board);
            }
        }

        if (numberOfIA != 0) {
            for (IA ia : listIA
                    ) {
                starter(ia, board);
            }
        }

        turnNumber= 0;

        while (!over) {

            if (numberOfPlayer != 0) {

                //=========================== fait jouer les joueur humain
                for (Player player : listPlayers
                        ) {
                    StdDraw.setPenColor(Color.white);
                    StdDraw.filledRectangle(0.5, 0.20, 0.4, 0.04);
                    StdDraw.setPenColor(Color.black);
                    StdDraw.text(0.5, 0.20, player.getName() + " cliquez sur une couleur pour jouer :");
                    board.graphicDisplay();
                    //afficher les option
                    Colors[] available = this.availableColors(listIA, listPlayers, totalOfPlayer);

                    //================================= fin possibilité ============================================


                    player.play(board, available[graphicalChoice(available)]);

                    player.updateScore(board);
                    addTurn();
                    board.displayConsole();
                    board.graphicDisplay();


                    //==================== affiche les scores



                    displayScore(turnNumber,player);

                    //================== verifie si personne gagne
                    if (player.getScore() >= maxScore) {
                        over = true;
                        isOverGraphic(player);
                        break;
                    }
                    //}


                }




            }

            if (numberOfIA != 0) {
                for (IA ia : listIA
                        ) {
                    ia.playIA(board, listPlayers, listIA, totalOfPlayer, this);
                    //ia.playBestIA(listPlayers,listIA,totalOfPlayer,this,availableColors(listIA,listPlayers,totalOfPlayer),board,board.getTokens());
                    addTurn();
                    ia.updateScore(board);
                    board.graphicDisplay();
                    displayScore(turnNumber,ia);
                    board.displayConsole();
                    System.out.println();
                    //affichage des scores
                    for (Player key1 : listPlayers) {
                        System.out.println(key1.getName() + " :" + key1.getScore());
                    }
                    for (IA key2 : listIA
                            ) {
                        System.out.println(key2.getName() + " :" + key2.getScore());
                    }

                    if (ia.getScore() >= maxScore) {
                        over = true;
                        isOverGraphic(ia);
                        break;
                    }

                }
            }
        }

    }


    public int graphicalChoice(Colors[] available){

        int colorToPlay = 0;
        for (int i = 0; i < available.length - 1; i++) {
            StdDraw.setPenColor(Colors.colorsToColor(available[i]));
            if (i == 0)
                StdDraw.filledSquare(0.125, 0.035, 0.125);
            if (i == 1)
                StdDraw.filledSquare(0.125 * 3, 0.035, 0.125);
            if (i == 2)
                StdDraw.filledSquare(0.125 * 5, 0.035, 0.125);
            if (i == 3)
                StdDraw.filledSquare(0.125 * 7, 0.035, 0.125);
        }

        // =========================== affiche les possibilité ====================================
        if (totalOfPlayer == 2) {
            while (true) {
                if (StdDraw.mousePressed()) {

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 2 && 0 < StdDraw.mouseX()) {
                        colorToPlay = 0;
                        System.out.println("hello, color to play : " + colorToPlay);
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 4 && 0.1251 * 2 < StdDraw.mouseX()) {
                        colorToPlay = 1;
                        System.out.println("hello, color to play : " + colorToPlay);
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 6 && 0.1251 * 4 < StdDraw.mouseX()) {
                        colorToPlay = 2;
                        System.out.println("hello, color to play : " + colorToPlay);
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 8 && 0.1251 * 6 < StdDraw.mouseX()) {
                        colorToPlay = 3;
                        System.out.println("hello, color to play : " + colorToPlay);
                        break;
                    }

                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }

        if (totalOfPlayer == 3) {
            while (true) {
                if (StdDraw.mousePressed()) {

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 2 && 0 < StdDraw.mouseX()) {
                        colorToPlay = 0;
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 4 && 0.1251 * 2 < StdDraw.mouseX()) {
                        colorToPlay = 1;
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 6 && 0.1251 * 4 < StdDraw.mouseX()) {
                        colorToPlay = 2;
                        break;
                    }

                }
            }

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
            }

        }

        if (totalOfPlayer == 4) {
            while (true) {
                if (StdDraw.mousePressed()) {

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 2 && 0 < StdDraw.mouseX()) {
                        colorToPlay = 0;
                        break;
                    }

                    if (StdDraw.mouseY() < 0.25 && StdDraw.mouseX() < 0.125 * 4 && 0.1251 * 2 < StdDraw.mouseX()) {
                        colorToPlay = 1;
                        break;
                    }

                }
            }

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
            }

        }
        return colorToPlay;
    }

    public void displayScore(int tour,Player player){
        if (tour%totalOfPlayer == 1){
            StdDraw.setPenColor(Color.white);
            StdDraw.filledRectangle(0.85, 1 - 0.7 + 4 * 0.16, 0.13, 0.05);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(0.85, 1 - 0.7 + 4 * 0.16, player.getName() + " : " + player.getScore());
        }

        if(tour%totalOfPlayer == 2){
            StdDraw.setPenColor(Color.white);
            StdDraw.filledRectangle(0.85, 1 - 0.7 + 3 * 0.16, 0.13, 0.05);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(0.85, 1 - 0.7 + 3 * 0.16, player.getName() + " : " + player.getScore());

        }

        if(tour%totalOfPlayer == 3){
            StdDraw.setPenColor(Color.white);
            StdDraw.filledRectangle(0.85, 1 - 0.7 + 2 * 0.16, 0.13, 0.05);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(0.85, 1 - 0.7 + 2 * 0.16, player.getName() + " : " + player.getScore());

        }

        if (tour%totalOfPlayer == 0){
            StdDraw.setPenColor(Color.white);
            StdDraw.filledRectangle(0.85, 1 - 0.7 + 1 * 0.16, 0.13, 0.05);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(0.85, 1 - 0.7 + 1 * 0.16, player.getName() + " : " + player.getScore());
        }


    }

    public void start() {
        double maxScore = (board.getTokens().length * board.getTokens().length)/totalOfPlayer;
        over = false;

        if(numberOfPlayer!=0){
            for (Player player : listPlayers
                    ) {
                starter(player, board);
            }
        }

        if (numberOfIA!=0){
            for (IA ia : listIA
                    ) {
                starter(ia, board);
            }
        }

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

    public int askNumberOfPlayer(){
        StdDraw.clear();
        Font font = new Font("Helvetica",1,18);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0.5,1-0.03,"Choisissez le nombre de joueur");
        StdDraw.line(0,1-0.06,1,1-0.06);
        StdDraw.text(0.5,1-0.03*5,"0");
        StdDraw.line(0,1-0.06*4,1,1-0.06*4);
        StdDraw.text(0.5,1-0.03*11,"1");
        StdDraw.line(0,1-0.06*7,1,1-0.06*7);
        StdDraw.text(0.5,1-0.03*18,"2");
        StdDraw.line(0,1-0.06*10.5,1,1-0.06*10.5);
        StdDraw.text(0.5,1-0.03*25,"3");
        StdDraw.line(0,1-0.06*14,1,1-0.06*14);
        StdDraw.text(0.5,1-0.03*31,"4");




        while (true){
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.03 && 1-0.06*4<StdDraw.mouseY()){
                int i = 0;
                System.out.println(i);
                return i;


            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*4 && 1-0.06*7<StdDraw.mouseY()){
                int i = 1;
                System.out.println(i);
                return i;

            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*7) && (1-0.06*10.5)<StdDraw.mouseY()){
                int i = 2;
                System.out.println(i);
                return i;

            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*10.5) && 1-0.06*14<StdDraw.mouseY()){
                int i = 3;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*14 && 0<StdDraw.mouseY()){
                int i = 4;
                System.out.println(i);
                return i;
            }


            try { Thread.sleep(80) ;  }  catch (InterruptedException e) {  }



        }
    }

    public int askNumberOfIA(){
        int i = 2;
        if (numberOfPlayer!=0){
        StdDraw.clear();
            try { Thread.sleep(500) ;  }  catch (InterruptedException e) {  }
        Font font = new Font("Helvetica",1,18);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0.5,1-0.03,"Choisissez le nombre de d'IA (ne pas depasser 4 Joueurs)");
        StdDraw.line(0,1-0.06,1,1-0.06);
        StdDraw.text(0.5,1-0.03*5,"0");
        StdDraw.line(0,1-0.06*4,1,1-0.06*4);
        StdDraw.text(0.5,1-0.03*11,"1");
        StdDraw.line(0,1-0.06*7,1,1-0.06*7);
        StdDraw.text(0.5,1-0.03*18,"2");
        StdDraw.line(0,1-0.06*10.5,1,1-0.06*10.5);
        StdDraw.text(0.5,1-0.03*25,"3");
        StdDraw.line(0,1-0.06*14,1,1-0.06*14);
        StdDraw.text(0.5,1-0.03*31,"4");




        while (true){
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.03 && 1-0.06*4<StdDraw.mouseY()){
                i = 0;
                System.out.println(i);
                return i;

            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*4 && 1-0.06*7<StdDraw.mouseY()){
                 i = 1;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*7) && (1-0.06*10.5)<StdDraw.mouseY()){
                 i = 2;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*10.5) && 1-0.06*14<StdDraw.mouseY()){
                 i = 3;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*14 && 0<StdDraw.mouseY()){
                 i = 4;
                System.out.println(i);
                return i;
            }


            try { Thread.sleep(80) ;  }  catch (InterruptedException e) {  }



        }
    }
        if (this.numberOfPlayer==0){
                StdDraw.clear();
                Font font = new Font("Helvetica",1,18);
                StdDraw.setFont(font);
                StdDraw.setPenColor(Color.black);
                StdDraw.text(0.5,1-0.03,"Choisissez le nombre de d'IA");
                StdDraw.line(0,1-0.06,1,1-0.06);
                StdDraw.text(0.5,1-0.03*5,"2");
                StdDraw.line(0,1-0.06*4,1,1-0.06*4);
                StdDraw.text(0.5,1-0.03*11,"3");
                StdDraw.line(0,1-0.06*7,1,1-0.06*7);
                StdDraw.text(0.5,1-0.03*18,"4");
                StdDraw.line(0,1-0.06*10.5,1,1-0.06*10.5);





                while (true){
                    if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.03 && 1-0.06*4<StdDraw.mouseY()){
                         i = 2;
                        System.out.println(i);
                        return i;

                    }
                    if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*4 && 1-0.06*7<StdDraw.mouseY()){
                         i = 3;
                        System.out.println(i);
                        return i;
                    }
                    if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*7) && (1-0.06*10.5)<StdDraw.mouseY()){
                         i = 4;
                        System.out.println(i);
                        return i;
                    }



                    try { Thread.sleep(80) ;  }  catch (InterruptedException e) {  }



                }
        }

        return i;
    }

    public int askSizeBoard(){
        StdDraw.clear();
        Font font = new Font("Helvetica",1,18);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0.5,1-0.03,"Choisissez la taille du plateau de jeux");
        StdDraw.line(0,1-0.06,1,1-0.06);
        StdDraw.text(0.5,1-0.03*5,"6");
        StdDraw.line(0,1-0.06*4,1,1-0.06*4);
        StdDraw.text(0.5,1-0.03*11,"12");
        StdDraw.line(0,1-0.06*7,1,1-0.06*7);
        StdDraw.text(0.5,1-0.03*18,"20");
        StdDraw.line(0,1-0.06*10.5,1,1-0.06*10.5);
        StdDraw.text(0.5,1-0.03*25,"30");
        StdDraw.line(0,1-0.06*14,1,1-0.06*14);
        StdDraw.text(0.5,1-0.03*31,"40");




        while (true){
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.03 && 1-0.06*4<StdDraw.mouseY()){
                int i = 6;
                System.out.println(i);
                return i;

            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*4 && 1-0.06*7<StdDraw.mouseY()){
                int i = 12;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*7) && (1-0.06*10.5)<StdDraw.mouseY()){
                int i = 20;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<(1-0.06*10.5) && 1-0.06*14<StdDraw.mouseY()){
                int i = 30;
                System.out.println(i);
                return i;
            }
            if (StdDraw.mousePressed() && StdDraw.mouseY()<1-0.06*14 && 0<StdDraw.mouseY()){
                int i = 40;
                System.out.println(i);
                return i;
            }


            try { Thread.sleep(80) ;  }  catch (InterruptedException e) {  }



        }
    }

    public void isOverGraphic(Player player) {
        winner = player;
        System.out.println("le gagnant est : " + winner.getName());

        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(0.5, 0.20, 0.7, 0.04);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(0.5, 0.20, "!! "+winner.getName() + " est le gagnant de la partie avec : "+winner.getScore()+" points !!");

    }

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

    public int getTurnNumber() {
        return turnNumber;
    }

    public void addTurn(){
        turnNumber = turnNumber+1;
    }

    public int getTotalOfPlayer() {
        return totalOfPlayer;
    }
}
