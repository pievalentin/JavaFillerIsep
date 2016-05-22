/**
 * Created by Pierre Valentin on 19/04/2016.
 */
public class Board {
	private int numberOfPlayer;
	private Token[][] tokens;
	private int size;


	public Board(int size){
		this.size=size;
		this.tokens= new Token[size][size];
		initializeBoard();


	}

	public static void take(Colors color, Player player){

	}

	public void initializeBoard(){
		for (Token[] array: tokens
			 ) {
			for (Token token: array
				 ) {
					token = new Token();
					//System.out.println("hello");
					token.setColor(Colors.randomColor());
					System.out.println(Colors.colorsToString(token.getColor()));
					token.setPossesed(false);

			}
			
		}
		
	}

	public void displayConsole(){
		for (Token[] array: tokens
				) {

			System.out.println("pass one line");

			for (Token token: array
					) {
				System.out.println(Colors.colorsToString(token.getColor()));

			}

		}

	}




}
