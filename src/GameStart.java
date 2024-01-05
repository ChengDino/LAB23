import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameStart extends JFrame {

    Image offScreenImg = null;

    // creation object
    HeadObj headObj = new HeadObj(Img.getHead_right(), 90, 540, this);
    FoodObj foodObj = new FoodObj().getFood();
    // Menu menu = new Menu(this, 0);
    // creation body
    public List<BodyObj> bodyList = new ArrayList<>();

    public void Start() {

        this.setSize(800, 600); // I select window size
        this.setLocationRelativeTo(null); // position of the window on the screen
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        bodyList.add(new BodyObj(Img.getBody(), 60, 540, this));
        bodyList.add(new BodyObj(Img.getBody(), 30, 540, this));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // 0.not started //2.pause //3.gameover
                    if (headObj.getState() == 0 || headObj.getState() == 2 || headObj.getState() == 3) {
                        headObj.setState(1);

                    } else if (headObj.getState() == 1) {
                        headObj.setState(2);
                        repaint();
                    } else if (headObj.getState() == 3) {
                        repaint();
                    }
                }
            }
        });

        while (true) {

            if (headObj.getState() == 1) {
                repaint();
            }
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
            offScreenImg = this.createImage(800, 600);
        }
        Graphics gImg = offScreenImg.getGraphics();

        gImg.setColor(Color.GRAY);
        gImg.fillRect(0, 0, 800, 600); // fill the window (background)
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

        // draw Score
        Img.WriteText(gImg, String.valueOf(headObj.getScore()), Color.RED, 50, 650, 300);
        Img.WriteText(gImg, "SCORE", Color.RED, 25, 650, 250);

        if (headObj.getState() == 0) {
            message(gImg);
            Img.WriteText(gImg, "Press space to start the game ", Color.BLUE, 25, 150, 175);
        }
        if (headObj.getState() == 2) {
            message(gImg);
            Img.WriteText(gImg, "Press space to continue the game ", Color.BLUE, 25, 150, 175);
        }
        if (headObj.getState() == 3) {
            gImg.setColor(Color.GRAY);
            gImg.fillRect(140, 220, 430, 120);
            Img.WriteText(gImg, "GameOver ", Color.BLUE, 25, 150, 265);
            Img.WriteText(gImg, "Press space to restart the game ", Color.BLUE, 25, 150, 300);
        }

        g.drawImage(offScreenImg, 0, 0, null);

    }

    public void message(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(140, 140, 430, 60);

    }

    public static void main(String[] args) {

        GameStart startgame = new GameStart();
        startgame.Start();

    }

}