import java.awt.Graphics;
import java.awt.Image; 

public class FoodObj extends GameObj {


    @Override
    public void paintSelf(Graphics g) {

        super.paintSelf(g);
    }

    public FoodObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
    }

}
