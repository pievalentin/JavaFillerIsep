public class Token {
    private Colors color;
    private Player owner;
    boolean possessed;

    public boolean eat(Player player, Colors color) {
        if (this.getOwner() == player && this.getColor()!=color) {
            this.owner = player;
            this.possessed = true;
            this.color = color;
            return true;
        }

        if (this.isAvailable(color)) {
            this.owner = player;
            this.possessed = true;
            this.color = color;
            return true;
        }

        return false;
    }

    public Token(Colors color, Player owner, boolean possessed) {
        this.color = color;
        this.owner = owner;
        this.possessed = possessed;
    }

    public Token(Colors color, boolean possessed) {
        this.color = color;
        this.possessed = possessed;
    }

    public boolean isAvailable(Colors color){
        Boolean result;
        result = !this.isPossessed() && this.getColor() == color;


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

    public boolean isPossessed() {
        return possessed;
    }

    public void setPossessed(boolean possessed) {
        this.possessed = possessed;
    }
}

