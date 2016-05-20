
public class Player {

	private String Nom;
	private Score score;

	public void play(){
		Colors color;
		color = askColor();


	}

	public Colors askColor(){
		//TODO ask color
		String answer;
		answer = Keyboard.askString();


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
