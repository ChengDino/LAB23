import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HeadObj extends GameObj {
    // Direction up,down,rihgt,left
    private String direction = "right";

    public void move() {

        java.util.List<BodyObj> bodyList = this.frame.bodyList;

        for (int i = bodyList.size() - 1; i >= 1; i--) {
            
            bodyList.get(i).setX(bodyList.get(i - 1).getX());
            bodyList.get(i).setY(bodyList.get(i - 1).getY());
            
            // game over
            if (getX() == bodyList.get(i).getX() && getY() == bodyList.get(i).getY()) {
                setState(3);
                
                // restart game  
                setScore(0); // score 
                for (i = bodyList.size() - 1; bodyList.size() != 2; i--){
                    
                    bodyList.remove(i); // body
                    
                }
            }
            
        }

        bodyList.get(0).setX(getX());
        bodyList.get(0).setY(getY());

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

        int newX = -90;
        int newY = -90;
        BodyObj lastBody = this.frame.bodyList.get(this.frame.bodyList.size() - 1);

        FoodObj food = this.frame.foodObj;
        if (food.getX() == getX() && food.getY() == getY()) {
            this.frame.foodObj = food.getFood();
            newX = lastBody.getX();
            newY = lastBody.getY();
            setScore(getScore() + 1); // Increase point score
        }
        move();
        // increase body one unit
        if (newX != -90 && newY != -90) {
            this.frame.bodyList.add(new BodyObj(Img.getBody(), newX, newY, this.frame));
        }

        if (getX() >= 600) {

            setX(0);

        } else if (getX() <= -1) {

            setX(600 - 30);

        }

        if (getY() == 600) {

            setY(30);

        } else if (getY() == 0) {

            setY(600 - 30);

        }

    }

    public HeadObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
        this.frame.addKeyListener(new KeyAdapter() {

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
                    setImg(Img.getHead_left());
                }

                break;

            case KeyEvent.VK_W:
                if (!"down".equals(direction)) {
                    direction = "up";
                    setImg(Img.getHead_up());
                }

                break;

            case KeyEvent.VK_S:
                if (!"up".equals(direction)) {
                    direction = "down";
                    setImg(Img.getHead_down());
                }

                break;

            case KeyEvent.VK_D:
                if (!"left".equals(direction)) {
                    direction = "right";
                    setImg(Img.getHead_right());
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
