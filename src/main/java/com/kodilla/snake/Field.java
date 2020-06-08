package com.kodilla.snake;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Field extends Pane {
    private int w,h;

    ArrayList<Block> blocks = new ArrayList<Block>();
    SnakeClass snake;

    public Field(int width, int height){
        w = width;
        h = height;

        setMinSize(w*GamePlayer.blockSize, h*GamePlayer.blockSize);
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

    public void addSnakeClass(SnakeClass s){
        snake= s;
        for(Block b: s.blocks){
            addBlock(b);
        }


    }

    private void addBlock(Block b){
        getChildren().add(b);
        blocks.add(b);
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
