package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSnake {

    @Test
    public void testFoodCreationWithinRange() {
        // Creare un'istanza di GameStart
        GameStart game = new GameStart();

        // Creare più oggetti cibo e verificarne le coordinate
        for (int i = 0; i < 10000; i++) {
            // Creare un nuovo oggetto cibo
            FoodObj food = game.foodObj.getFood();

            // Verificare che le coordinate x e y dell'oggetto cibo siano comprese tra 30 e 570
            assertTrue(food.getX() >= 30 && food.getX() <= 570);
            assertTrue(food.getY() >= 30 && food.getY() <= 570);
        }
    }
    
}