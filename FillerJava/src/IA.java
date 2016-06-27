import java.util.Random;

public class IA extends Player {





    // ================================== SET LA COULEUR DE L'IA ==============================




    public IA(int startX, int startY) {
        super(startX, startY);
    }

    public void playIA(Board board, Player[] listPlayer, IA[] listIA, int numbOfPlayer, Game game) {
        Colors color;
        boolean check = true;
        color = decideColorRandom(listPlayer, listIA, numbOfPlayer, game);
        this.setPlayerColor(color);
        board.take(color, this);

        System.out.println("l'ia joue :"+Colors.colorsToString(color).toLowerCase());
    }

    public void playBestIA(Player[] listPlayer, IA[] listIA, int numbOfPlayer, Game game,Colors[] available, Board board, Token[][] tokens) {
        Colors color;
        color = decideBestColor(listPlayer,listIA,numbOfPlayer,game,available,board,tokens);
        this.setPlayerColor(color);
        board.take(color, this);
        System.out.println("l'ia joue :"+Colors.colorsToString(Colors.randomColor()).toLowerCase());
    }


    public static Colors decideColorRandom(Player[] listPlayer, IA[] listIA, int numbOfPlayer, Game game) {
        Colors color;
        Colors[] available = game.availableColors(listIA, listPlayer, numbOfPlayer);
        Random generator = new Random();
        int randomIndex = generator.nextInt(available.length-1);
        color = available[randomIndex];
        return color;
    }


    public Colors decideBestColor(Player[] listPlayer, IA[] listIA, int numbOfPlayer, Game game,Colors[] available, Board board, Token[][] tokens){
        Colors result = Colors.BLUE;
        int indexToChoose = 0;
        int[] scores = new int[6-numbOfPlayer];
        Board testBoard = new Board (tokens.length);
        for (int i = 0; i <available.length-1; i++) {

            //on clone le board
            for (int j = 0; j <tokens.length ; j++) {
                for (int k = 0; k <tokens.length ; k++) {
                    testBoard.getTokens()[i][j].setColor(tokens[i][j].getColor());
                    testBoard.getTokens()[i][j].setPossessed(tokens[i][j].isPossessed());
                    testBoard.getTokens()[i][j].setOwner(tokens[i][j].getOwner());
                }
            }

            testBoard.take(available[i],this);
            int score = testBoard.calculateOwnership(this);
            scores[i]=score;

        }

        for (int i = 0; i <available.length-1 ; i++) {
            System.out.println(scores.toString());
            if (indexToChoose<=scores[i])
                indexToChoose=i;

        }

        result=available[indexToChoose];
        return result;


    }

}
