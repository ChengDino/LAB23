
import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObj {
    private Image img;
    // positions
    private int x;
    private int y;
    // size img
    private int width = 30;
    private int height = 30;
    GameStart frame;
    private int score = 0;
    private int state = 0;

    // this is a costructor of class GameObj with parameters
    public GameObj(Image img, int x, int y, int width, int height, GameStart frame) {

        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.frame = frame;

    }

    public GameObj(Image img, int x, int y, GameStart frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.frame = frame;
    }

    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, width, height, null);

    }

    // this is a costructor of class GameObj without parameters
    public GameObj() {

    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /*
     * public GameStart getFrame() {
     * return frame;
     * }
     * 
     * public void setFrame(GameStart frame) {
     * this.frame = frame;
     * }
     */
}
