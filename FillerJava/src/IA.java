/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class IA extends Player {
    String name;
    int score;

    public IA(int startX, int startY) {
        super(startX, startY);
    }

    public void play(Board board) {
        Colors color;
        color = decideColor1();
        board.take(color, this);
    }

    public Colors decideColor1(){
        Colors color;
        color = Colors.randomColor();
        return color;
    }

}
