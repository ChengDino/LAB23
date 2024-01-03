import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class FoodObj extends GameObj {

    Random r = new Random();

    // position food
    public FoodObj getFood() {
        return new FoodObj(Img.food, (r.nextInt(18) + 2) * 30, (r.nextInt(18) + 2) * 30, this.frame);
    }

    public FoodObj() {
    }

    @Override
    public void paintSelf(Graphics g) {

        super.paintSelf(g);
    }

    public FoodObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
    }

}
