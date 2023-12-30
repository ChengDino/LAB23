import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HeadObj extends GameObj {
    // Direction up,down,rihgt,left
    private String direction = "right";

    public void move() {

        java.util.List<BodyObj> bodyList = this.getFrame().bodyList;

        for (int i = 1; i < bodyList.size(); i++) {
            bodyList.get(i).setX(bodyList.get(i - 1).getX()); 
            bodyList.get(i).setY(bodyList.get(i - 1).getY());
            }
            
                bodyList.get(0).setX(this.getX());
                bodyList.get(0).setY(this.getY());
            
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

        if (getX() >= 600) {
            
            setX(0);

        }
        else if (getX() <= -1) {

            setX(600-30);
            
        }

        if (getY() == 600) {
            
            setY(30);

        }
        else if (getY() == 0) {

            setY(600-30);

        }

        super.paintSelf(g);
        move();

    }

    public HeadObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
        this.getFrame().addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                ControlDirection(e);
            }
        });
    }

    // w -up a -left d-right s -down
    public void ControlDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                if (!"right".equals(direction)) {
                    direction = "left";
                    setImg(Img.head_left);
                }

                break;

            case KeyEvent.VK_W:
                if (!"down".equals(direction)) {
                    direction = "up";
                    setImg(Img.head_up);
                }

                break;

            case KeyEvent.VK_S:
                if (!"up".equals(direction)) {
                    direction = "down";
                    setImg(Img.head_down);
                }

                break;

            case KeyEvent.VK_D:
                if (!"left".equals(direction)) {
                    direction = "right";
                    setImg(Img.head_right);
                }

                break;

            default:
                break;
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
