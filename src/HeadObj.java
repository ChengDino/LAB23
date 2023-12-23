import java.awt.Graphics;
import java.awt.Image;

public class HeadObj extends GameObj {
    // Direction up,down,rihgt,left
    private String direction = "right";

    @Override
    public void paintSelf(Graphics g) {

        super.paintSelf(g);
        
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
