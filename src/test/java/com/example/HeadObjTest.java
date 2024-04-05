package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeadObjTest {

    @Test
    public void testMove() {

        GameStart game = new GameStart();
        HeadObj head = new HeadObj(null, 0, 0, game);

        head.setX(0);
        head.setY(0);
        head.setDirection("right");

        head.move();

        assertEquals(30, head.getX());
        assertEquals(0, head.getY());
    }
}