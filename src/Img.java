import java.awt.*;
import java.awt.Font;

public class Img {

        public static Image head_down = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_down.png");
        public static Image head_up = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_up.png");
        public static Image head_left = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_left.png");
        public static Image head_right = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_right.png");
        public static Image body = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\body.png");
        public static Image food = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\food.png");

        // Point score
    public static void WriteText(Graphics g, String score, Color color, int size, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString(score, x, y);

    }

}