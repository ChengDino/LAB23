package com.example;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameStart extends JFrame {

    Image offScreenImg = null;

    // creation object
    HeadObj headObj = new HeadObj(Img.getHead_right(), 90, 540, this);
    FoodObj foodObj = new FoodObj().getFood();
    // Menu menu = new Menu(this, 0);
    // creation body
    public List<BodyObj> bodyList = new ArrayList<>();

    public void Start() {

        this.setSize(800, 600); // I select window size
        this.setLocationRelativeTo(null); // position of the window on the screen
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        bodyList.add(new BodyObj(Img.getBody(), 60, 540, this));
        bodyList.add(new BodyObj(Img.getBody(), 30, 540, this));

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("src\\sound\\music.wav")));

            this.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        // 0.not started // 1.started //2.pause //3.gameover
                        if (headObj.getState() == 0 || headObj.getState() == 2 || headObj.getState() == 3) {
                            headObj.setState(1);
                            clip.setMicrosecondPosition(clip.getMicrosecondPosition());
                            clip.start();
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else if (headObj.getState() == 1) {
                            headObj.setState(2);
                            repaint();
                        }

                    }

                }

            });

            while (true) {

                if (headObj.getState() == 1) {

                    repaint();
                } else {
                    clip.stop();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // I rewrite the graphics method
    @Override
    public void paint(Graphics g) {

        if (offScreenImg == null) {
            offScreenImg = this.createImage(800, 600);
        }
        Graphics gImg = offScreenImg.getGraphics();

        gImg.setColor(new Color(142, 243, 246));
        gImg.fillRect(0, 0, 800, 600); // fill the window (background)
        gImg.setColor(new Color(207, 249, 250));
        for (int i = 0; i <= 20; i++) {
            gImg.drawLine(0, i * 30, 600, i * 30);
            gImg.drawLine(i * 30, 0, i * 30, 600);
        }
        // draw Body
        for (int i = bodyList.size() - 1; i >= 0; i--) {
            bodyList.get(i).paintSelf(gImg);
        }

        // draw Head
        headObj.paintSelf(gImg);

        // draw Food
        foodObj.paintSelf(gImg);

        // draw Score
        Img.WriteText(gImg, String.valueOf(headObj.getScore()), Color.black, 50, 650, 300);
        Img.WriteText(gImg, "SCORE", Color.black, 25, 650, 250);

        if (headObj.getState() == 0) {
            Img.WriteText(gImg, "Press space to start the game ", Color.blue, 25, 150, 175);
        }
        if (headObj.getState() == 2) {

            Img.WriteText(gImg, "Press space to continue the game ", Color.blue, 25, 150, 175);

        }
        if (headObj.getState() == 3) {

            Img.WriteText(gImg, "GameOver ", Color.red, 35, 150, 245);
            Img.WriteText(gImg, "Press space to restart the game ", Color.blue, 25, 150, 300);
            headObj.setScore(0); // refresh score

        }

        g.drawImage(offScreenImg, 0, 0, null);

    }

    public static void main(String[] args) {

        GameStart startgame = new GameStart();
        startgame.Start();

    }

}