import java.awt.*;
import java.awt.Font;

public class Img {

        private static Image head_down = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_down.png");
        private static Image head_up = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_up.png");
        private static Image head_left = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_left.png");
        private static Image head_right = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\head_right.png");
        private static Image body = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\body.png");
        private static Image food = Toolkit.getDefaultToolkit()
                .getImage("src\\img\\food.png");

        // Point score
    public static void WriteText(Graphics g, String score, Color color, int size, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString(score, x, y);

    }

public static Image getHead_down() {
        return head_down;
}

public static void setHead_down(Image head_down) {
        Img.head_down = head_down;
}

public static Image getHead_up() {
        return head_up;
}

public static void setHead_up(Image head_up) {
        Img.head_up = head_up;
}

public static Image getHead_left() {
        return head_left;
}

public static void setHead_left(Image head_left) {
        Img.head_left = head_left;
}

public static Image getHead_right() {
        return head_right;
}

public static void setHead_right(Image head_right) {
        Img.head_right = head_right;
}

public static Image getBody() {
        return body;
}

public static void setBody(Image body) {
        Img.body = body;
}

public static Image getFood() {
        return food;
}

public static void setFood(Image food) {
        Img.food = food;
}

}