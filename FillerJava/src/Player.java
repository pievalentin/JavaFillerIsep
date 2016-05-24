
public class Player {


    private String Nom;
    private Score score;
    private int startI;
    private int startJ;

    public Player(String nom, int startI, int startJ) {
        Nom = nom;
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
        return startX;
    }

    public void setStartI(int startX) {
        this.startX = startX;
    }

    public int getStartJ() {
        return startY;
    }

    public void setStartJ(int startY) {
        this.startY = startY;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public double getScore() {
        return score.getScore();
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
