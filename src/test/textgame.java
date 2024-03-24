package test;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import main.java.GameStart;
import main.java.HeadObj;

public class textgame {

    public static void main(String[] args) throws AWTException, InterruptedException {
        testMovimento();
    }

    public static void testMovimento() throws AWTException, InterruptedException {
        // Inizializza un oggetto HeadObjwasd

        GameStart game = new GameStart();
        HeadObj head = new HeadObj(null, 0, 0, game);

        // Simula il movimento verso l'alto
        head.ControlDirection(
                new KeyEvent(game, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));

        if (!"up".equals(head.getDirection())) {
            System.out.println("Test fallito: la direzione dovreWDbbe essere 'up' dopo aver premuto 'W'");

        } else {
            System.out.println(head.getDirection());
        }

        // Simula il movimento verso sinistra wasd
        head.ControlDirection(
                new KeyEvent(game, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A'));
        Thread.sleep(1000);

        if (!"left".equals(head.getDirection())) {
            System.out.println("Test fallito: la direzione dovrebbe essere 'left' dopo aver premuto 'A'");
        }

        // Simula il movimento verso il basso
        head.ControlDirection(
                new KeyEvent(game, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S'));
        Thread.sleep(1000);
        if (!"down".equals(head.getDirection())) {
            System.out.println("Test fallito: la direzione dovrebbe essere 'down' dopo aver premuto 'S'");
        }

        // Simula il movimento verso destra
        head.ControlDirection(
                new KeyEvent(game, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D'));
        Thread.sleep(1000);
        if (!"right".equals(head.getDirection())) {
            System.out.println("Test fallito: la direzione dovrebbe essere 'right' dopo aver premuto 'D'");
        }

        // Puoi aggiungere ulteriori test per altri casi di movimento se necessario
    }
}
