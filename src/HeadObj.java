import java.awt.Graphics;
import java.awt.Image;

public class HeadObj extends GameObj {
    // Direction up,down,rihgt,left
    private String direction = "right";

    public void move() {
        switch (direction) {
            case "up":
                setY(getY() - 30);
                break;
            case "down":
                setY(getY() + 30);
                break;
            case "left":
                setX(getX() - 30);
                break;
            case "right":
                setX(getX() + 30);
                break;

            default:
                break;
        }
    }

    @Override
    public void paintSelf(Graphics g) {

        super.paintSelf(g);
        // move();

    }

    public HeadObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
