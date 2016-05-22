import java.util.Random;

/**
 * Created by Pierre Valentin on 19/04/2016.
 */

public enum Colors {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    VIOLET;

    public static Colors randomColor(){
        Colors[] color = Colors.values();
        Random generator = new Random();
        return color[generator.nextInt(color.length)];
    }

    public static String colorsToString(Colors color){
        String result = "not set" ;
        switch (color){
            case RED:
                result="R";
                break;
            case GREEN:
                result="G";
                break;
            case BLUE:
                result="B";
                break;
            case YELLOW:
                result="Y";
                break;
            case ORANGE:
                result="O";
                break;
            case VIOLET:
                result="V";
                break;
        }

        return result;

    }
}
