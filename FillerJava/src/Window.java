import javax.swing.*;
import java.awt.*;

/**
 * Created by Pierre Valentin on 01/06/2016.
 */
public class Window extends JFrame {
    public Window() {
        this.setTitle("Filler");
        this.setLocationRelativeTo(null);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(true);
        this.setContentPane(new Square(100, 100));
        this.setVisible(true);
    }

    public void plus() {
        JPanel background = new JPanel();

        background.setBackground(Color.gray);

        this.setContentPane(background);
        this.setContentPane(new Square(10, 10));
    }


}
