package com.kodilla.snake;

import com.kodilla.snake.demo.Main;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Field extends Pane {
    private int w,h;

    ArrayList<Block> blocks = new ArrayList<Block>();
    Snake snake;

    public Field(int width, int height){
        w = width;
        h = height;

        setMinSize(650, 575);
        setLayoutX(25);
        setLayoutY(100);
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

    }

    public void addSnake(Snake s){
        snake = s;
        for(Block b: s.blocks){
            addBlock(b);
        }
    }

    public void update(){
        for(Block b:blocks) {
            b.update();
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
