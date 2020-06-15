package com.kodilla.snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Food extends Circle {
    int posX, posY;

    public Food(int x, int y){
        super(0.5*Main.blockSize);
        posX = x;
        posY = y;
        setTranslateX(posX*Main.blockSize);
        setTranslateY(posY*Main.blockSize);

        setFill(Color.RED);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;

    }
}
