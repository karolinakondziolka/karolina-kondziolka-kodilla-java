package com.kodilla.snake.demo;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle {

    int posX, posY;



    public Food(int x, int y) {
        super(Main.block_size,  Main.block_size, Color.RED);
        posX = x;
        posY = y;
        setTranslateX(posX * Main.block_size);
        setTranslateY(posY * Main.block_size);

        Image image = new Image("apple.png");
        ImagePattern imagePattern = new ImagePattern(image);

        setFill(imagePattern);
        setHeight(20);
        setWidth(20);


    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

