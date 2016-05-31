import java.util.Random;

/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class IA extends Player {
    String name;
    int score;

    public IA(int startX, int startY) {
        super(startX, startY);
    }

    public void playIA(Board board, Player[] listPlayer, int numbOfPlayer) {
        Colors color;
        System.out.println("l'ia joue");
        color = decideColorRandom(listPlayer, numbOfPlayer);
        board.take(color, this);
    }



    public static Colors[] availableColors(Player[] listPlayer,int numbOfPlayer){
        Colors[] result = new Colors[numbOfPlayer];

        for (int i = 0; i <numbOfPlayer ; i++) {
            result[i]=listPlayer[i].getPlayerColor();
        }
        return result;
    }

    public static Colors decideColorRandom(Player[] listPlayer, int numbOfPlayer){
        Colors color;
        Colors[] available = availableColors(listPlayer, numbOfPlayer);
        Random generator = new Random();
        int randomIndex = generator.nextInt(numbOfPlayer);
        color = available[randomIndex];
        return color;
    }

}
