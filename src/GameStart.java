import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class GameStart extends JFrame {

    HeadObj headObj = new HeadObj(Img.head_right, 30, 540, this);
    FoodObj foodObj = new FoodObj(Img.food, 60,60, this);

    public void Start() {

        this.setSize(600, 600); // I select window size
        this.setLocationRelativeTo(null); // position of the window on the screen
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    // I rewrite the graphics method
    @Override
    public void paint(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 600, 600); // fill the window (background)
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 20; i++) {
            g.drawLine(0, i * 30, 600, i * 30);
            g.drawLine(i * 30, 0, i * 30, 600);
        }
        // draw Head
        headObj.paintSelf(g);

        // draw Food
        foodObj.paintSelf(g);
    }

    public static void main(String[] args) {

        GameStart startgame = new GameStart();
        startgame.Start();

    }

}