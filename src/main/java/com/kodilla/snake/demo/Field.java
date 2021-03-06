package com.kodilla.snake.demo;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;


public class Field extends Pane {

    private int w,h;
    Player player;
    ArrayList<Block> blocks = new ArrayList<Block>();

    int score = 0;
    int speed = 8;
    Food f;
    Snake snake;


    public Field(int width, int height, Player player) {
        w = width;
        h = height;
        this.player= player;

        setMinSize(w * Main.block_size, h * Main.block_size);
        setLayoutX(25);
        setLayoutY(100);
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        addFood();
    }
    public void setScore(int number){
        this.score = number;
    }
    public void addSnake(Snake s){
        snake = s;
        for(Block b: s.blocks){
            addBlock(b);
        }
    }
    public void update(){
        for(Block b:blocks){
            b.update();
        }
        if(isEaten(f)){
            this.player.addPoints(10);
            score +=10;
            addFood();
            addNewBlock();
            speed++;
            isDead();

        }
    }

    public boolean isDead(){
        for(Block b: blocks){
            if(b !=snake.head){
                if(b.posX == snake.head.posX && b.posY == snake.head.posY) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addNewBlock(){
        Block b = new Block(snake.tail.oldPosX, snake.tail.oldPosY, snake.tail, this);
        snake.tail = b;
        snake.tail.setFill(Color.GREENYELLOW);
        snake.tail.setStroke(Color.DARKOLIVEGREEN);
        addBlock(b);
    }

    private void addBlock(Block b){
        getChildren().add(b);
        blocks.add(b);
    }

    public void addFood(){
        int randomX = (int) (Math.random()*w);
        int randomY = (int) (Math.random()*h);

        Food food = new Food(randomX, randomY);
        getChildren().add(food);
        getChildren().remove(f);
        f=food;
    }

    public boolean isEaten(Food f){
        if(f== null){
            return false;
        }
        return f.getPosX() == snake.head.posX && f.getPosY() == snake.head.posY;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}