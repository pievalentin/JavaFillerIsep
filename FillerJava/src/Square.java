import javax.swing.*;
import java.awt.*;

/**
 * Created by Pierre Valentin on 01/06/2016.
 */
public class Square extends JPanel {
    int x;
    int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void paintComponent(Graphics g) {
        System.out.println("hello");
        g.setColor(Color.red);
        g.fillRect(x, y, 75, 75);
        g.setColor(Color.yellow);
        g.fillRect(20, 20, 50, 50);
    }
}
