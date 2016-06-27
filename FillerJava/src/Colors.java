import java.awt.*;
import java.util.Random;


public enum Colors {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    VIOLET;

    public static Colors randomColor() {
        Colors[] color = Colors.values();
        Random generator = new Random();
        return color[generator.nextInt(color.length)];
    }

    public static String colorsToString(Colors color) {
        String result = "not set";
        switch (color) {
            case RED:
                result = "R";
                break;
            case GREEN:
                result = "G";
                break;
            case BLUE:
                result = "B";
                break;
            case YELLOW:
                result = "Y";
                break;
            case ORANGE:
                result = "O";
                break;
            case VIOLET:
                result = "V";
                break;
        }

        return result;

    }


    public static Color colorsToColor(Colors colorToChange){
        Color result = Color.black;
        switch (colorToChange){
            case BLUE:  result = Color.BLUE;
                break;
            case RED:  result = Color.RED;
                break;
            case GREEN:  result = Color.GREEN;
                break;
            case YELLOW:  result = Color.YELLOW;
                break;
            case ORANGE:  result = Color.ORANGE;
                break;
            case VIOLET:  result = Color.MAGENTA;
                break;

        }

        return result;
    }
}
