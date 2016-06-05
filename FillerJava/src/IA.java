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
        int[] scores = new int[6-numbOfPlayer];
        for (int i = 0; i <available.length; i++) {
            for (int j = 0; j <tokens.length ; j++) {
                for (int k = 0; k <tokens.length ; k++) {

                }
            }


        }


        return result;


    }

}
