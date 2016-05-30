/**
 * Created by Pierre on 20/05/2016.
 */

import java.util.Scanner;

public class Keyboard {

    public static String askString(String ask) {
        System.out.println(ask);
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return string;
    }

    public static Colors stringToColor(String string) {
        Colors color = Colors.GREEN;
        switch (string) {
            case "r":
                color = Colors.RED;
                break;
            case "o":
                color = Colors.ORANGE;
                break;
            case "y":
                color = Colors.YELLOW;
                break;
            case "g":
                color = Colors.GREEN;
                break;
            case "b":
                color = Colors.BLUE;
                break;
            case "v":
                color = Colors.VIOLET;
                break;
        }

        return color;

    }
}
