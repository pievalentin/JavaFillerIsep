/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Score {
    int score;
    Player player;

    public Score(Player player) {
        this.player = player;
    }

    public int calculateScore(Board board) {
        int result;
        result = board.calculateOwnership(player);
        return result;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
