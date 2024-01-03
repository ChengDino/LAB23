import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class GameStart extends JFrame {

    Image offScreenImg = null;

    // creation object
    HeadObj headObj = new HeadObj(Img.head_right, 90, 540, this);
    FoodObj foodObj = new FoodObj().getFood();
    // creation body
    public List<BodyObj> bodyList = new ArrayList<>();

    public void Start() {

        this.setSize(600, 600); // I select window size
        this.setLocationRelativeTo(null); // position of the window on the screen
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        bodyList.add(new BodyObj(Img.body, 60, 540, this));
        bodyList.add(new BodyObj(Img.body, 30, 540, this));

        while (true) {
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    // I rewrite the graphics method
    @Override
    public void paint(Graphics g) {

        if (offScreenImg == null) {
            offScreenImg = this.createImage(600, 600);
        }
        Graphics gImg = offScreenImg.getGraphics();

        gImg.setColor(Color.GRAY);
        gImg.fillRect(0, 0, 600, 600); // fill the window (background)
        gImg.setColor(Color.BLACK);
        for (int i = 0; i <= 20; i++) {
            gImg.drawLine(0, i * 30, 600, i * 30);
            gImg.drawLine(i * 30, 0, i * 30, 600);
        }
        // draw Body
        for (int i = bodyList.size() - 1; i >= 0; i--) {
            bodyList.get(i).paintSelf(gImg);
        }

        // draw Head
        headObj.paintSelf(gImg);

        // draw Food
        foodObj.paintSelf(gImg);

        g.drawImage(offScreenImg, 0, 0, null);

    }

    public static void main(String[] args) {

        GameStart startgame = new GameStart();
        startgame.Start();

    }

}