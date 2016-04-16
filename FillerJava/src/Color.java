
public class Color {
	private String color;
	private String valid[] = {"red","orange","yellow","green","blue","violet"};
	
	public Color(String color){
		String colorLow=color.toLowerCase();
		
		if(isCorrect(colorLow)){
		this.color=color;
		}

	}
	
	private boolean isCorrect( String color){
		boolean result = false;
		String tester=color.toLowerCase();

		for (String key : valid) {
			if (tester == key){
				result=true;
				break;
			}
		}
		return result;
		
	}
}
