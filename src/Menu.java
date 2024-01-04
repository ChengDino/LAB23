import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends GameObj {
    public Menu(GameStart frame, int score) {
        super(frame, score);
        this.frame.addKeyListener (new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    switch (getState()) {
                        case 0://initialization
                            setState(1);
                            break;
                        case 1: // game start
                            setState(2);
                        case 2: // time out
                            setState(1);
                            break;
                            default: 
                                break;

                    }
                }
            }
        });
    }
    
    public Menu() {

    }

}
