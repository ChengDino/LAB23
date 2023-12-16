import javax.swing.JFrame;

public class GameStart extends JFrame {

    public void Start() {

        this.setSize(600, 600); // seleziono dimensione finestra
        this.setLocationRelativeTo(null); // posizione della finestra sullo schermo
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        GameStart startgame = new GameStart();
        startgame.Start();

    }

}