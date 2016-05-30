/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Score {
    double score;
    Player player;

    public Score(Player player) {
        this.player = player;
    }

    public double calculateScore(Board board) {
        double result;
        result = board.calculateOwnership(player);
        return result;

    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
