/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Player {


    private String name;
    private Score score;
    private int startI;
    private int startJ;

    public Player(String name, int startI, int startJ) {
        this.name = name;
        this.startI = startI;
        this.startJ = startJ;
    }

    public Player(int startI, int startJ) {
        this.startI = startI;
        this.startJ = startJ;
    }

    public void updateScore(Board board){
        double result =  score.calculateScore(board);
        score.setScore(result);
    }

    public void play(Board board) {
        Colors color;
        color = askColor();
        board.take(color, this);


    }

    public static Colors askColor() {
        String answer;
        Colors color;
        System.out.println("choisissez une couleur : ");
        answer = Keyboard.askString();
        color = Keyboard.stringToColor(answer);
        return color;

    }


    public int getStartI() {
        return startI;
    }

    public void setStartI(int startX) {
        this.startI = startX;
    }

    public int getStartJ() {
        return startJ;
    }

    public void setStartJ(int startY) {
        this.startJ = startY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score.getScore();
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
