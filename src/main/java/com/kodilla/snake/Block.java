package com.kodilla.snake;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    int posX;
    int posY;
    int oldPosX;
    int oldPosY;

    Block previous;

    public Block(int x, int y, Block previous){
        super(GamePlayer.blockSize, GamePlayer.blockSize);
        posX=x;
        posY=y;

        setTranslateX(posX* GamePlayer.blockSize);
        setTranslateY(posY* GamePlayer.blockSize);

    }
}


