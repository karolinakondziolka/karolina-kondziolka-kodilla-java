package com.kodilla.snake.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LevelMedium extends Rectangle {

    int posX, posY;
    static int foodColor = 0;
    Color cc;
    int speed = 5;

    public LevelMedium(int x, int y) {
        super(Main.block_size, Main.block_size);
        posX = x;
        posY = y;
        setTranslateX(posX * Main.block_size);
        setTranslateY(posY * Main.block_size);

        Image image = new Image("apple.jpg");
        ImageView imageView = new ImageView(image);

        setFill(Color.RED);


    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
