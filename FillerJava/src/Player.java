/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Player {


    private String name;
    private int score;
    private int startI;
    private int startJ;
    private Colors playerColor;



    public Player(String name, int startI, int startJ) {
        this.name = name;

        this.startI = startI;
        this.startJ = startJ;
        this.score = 0;
    }

    public Player(int startI, int startJ) {
        this.startI = startI;
        this.startJ = startJ;
        this.score = 0;
    }

    public void updateScore(Board board){
        this.setScore(board.calculateOwnership(this));
    }

    public void play(Board board, Player[] list) {
        Colors color;
        color = askColor(list);
        board.take(color, this);
        this.setPlayerColor(color);


    }

    public void play(Board board, Colors color){
        board.take(color, this);
        this.setPlayerColor(color);
    }

    public static Colors askColor(Player[] list) {
        String answer;
        Colors color;
        boolean incorrect = true;
        answer = Keyboard.askString("choisissez une couleur : ");
        color = Keyboard.stringToColor(answer);
        while(incorrect){
            for (Player key:list
                 ) {
                if(key.getPlayerColor() == color){
                    answer = Keyboard.askString("Vous avez choisis une couleur de l'adversaire recommencez : ");
                    color = Keyboard.stringToColor(answer);}

                    else
                    incorrect=false;
                }
            }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Colors getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Colors playerColor) {
        this.playerColor = playerColor;
    }


}
