
public class Token {
	private Color color;
	private Player owner;
	boolean possesed;
	
	public void eat(Player player){
		if(possesed==false){
			owner=player;
			possesed=true;
		}
	}
	
	
}
