package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class FoodObj extends GameObj {

    Random r = new Random();

    // (random) position food: Range (60 - 570)
    public FoodObj getFood() {
        return new FoodObj(Img.getFood(), (r.nextInt(18) + 2) * 30, (r.nextInt(18) + 2) * 30, this.frame);
    }

    public FoodObj() {
    }

    @Override
    public void paintSelf(Graphics g) {

        super.paintSelf(g);
    }

    // costructor food
    public FoodObj(Image img, int x, int y, GameStart frame) {
        super(img, x, y, frame);
    }

}
