import java.util.Arrays;
import java.util.Random;

/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class IA extends Player {





    // ================================== SET LA COULEUR DE L'IA ==============================




    public IA(int startX, int startY) {
        super(startX, startY);
    }

    public void playIA(Board board, Player[] listPlayer,IA[] listIA, int numbOfPlayer,Party party) {
        Colors color;
        boolean check = true;
        color = decideColorRandom(listPlayer,listIA,numbOfPlayer,party);
        board.take(color, this);
        System.out.println("l'ia joue :"+Colors.colorsToString(color).toLowerCase());
        this.setPlayerColor(color);
    }


    public static Colors decideColorRandom(Player[] listPlayer,IA[] listIA, int numbOfPlayer,Party party){
        Colors color;
        Colors[] available = party.availableColors(listIA,listPlayer,numbOfPlayer);
        Random generator = new Random();
        int randomIndex = generator.nextInt(available.length-1);
        color = available[randomIndex];
        return color;
    }

}
