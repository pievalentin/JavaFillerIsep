/**
 * Created by Pierre Valentin on 17/05/2016.
 */
public class Token {
    private Colors color;
    private Player owner;
    boolean possesed;

    public boolean eat(Player player, Colors color) {
        if (this.getOwner() == player && this.getColor()!=color) {
            this.owner = player;
            this.possesed = true;
            this.color = color;
            return true;
        }

        if (this.isAvailable(color)) {
            this.owner = player;
            this.possesed = true;
            this.color = color;
            return true;
        }

        return false;
    }

    public Token(Colors color, Player owner, boolean possesed) {
        this.color = color;
        this.owner = owner;
        this.possesed = possesed;
    }

    public Token(Colors color, boolean possesed) {
        this.color = color;
        this.possesed = possesed;
    }

    public boolean isAvailable(Colors color){
        Boolean result;
        result = !this.isPossesed() && this.getColor() == color;


        return result;

    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isPossesed() {
        return possesed;
    }

    public void setPossesed(boolean possesed) {
        this.possesed = possesed;
    }
}

