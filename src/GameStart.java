import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class GameStart extends JFrame {

    public void Start() {

        this.setSize(600, 600); // seleziono dimensione finestra
        this.setLocationRelativeTo(null); // posizione della finestra sullo schermo
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    // riscrivo metodo graphics
    @Override
    public void paint(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 600, 600); // riempire la finestra (sfondo)
        g.setColor(Color.BLACK);
        for (int i = 0; i <= 20; i++) {
            g.drawLine(0, i * 30, 600, i * 30);
            g.drawLine(i * 30, 0, i * 30, 600);
        }

    }

    public static void main(String[] args) {

        GameStart startgame = new GameStart();
        startgame.Start();

    }

}