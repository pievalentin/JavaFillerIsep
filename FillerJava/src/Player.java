
public class Player {

    private String Nom;
    private Score score;

    public void play(Board board) {
        Colors color;
        color = askColor();
        board.take(color, this);


    }

    public static Colors askColor() {
        String answer;
        Colors color;
        System.out.println("choissisez une couleur : ");
        answer = Keyboard.askString();
        color = Keyboard.stringToColor(answer);
        return color;

    }


    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
