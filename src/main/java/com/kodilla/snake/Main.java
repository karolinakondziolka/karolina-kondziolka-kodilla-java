package com.kodilla.snake;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Button saveGame;

    static int blockSize = 15;
    int width =650;
    int height = 575;
    int il = 4;
    long then = System.nanoTime();



    @Override
    public void start(Stage stage) {

        Image image = new Image("background.jpeg");
        ImageView imageView = new ImageView(image);

        Group root = new Group();
        Scene scene = new Scene(root, 700, 700);
        Field f = new Field(width, height);
        f.addSnake(new Snake(il, f));

        Label score = new Label("Score:0");
        score.setFont(new Font("Arial",16));
        score.setLayoutX(40);
        score.setLayoutY(40);

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (now - then > 1000000000 / 8) {
                    f.update();
                    then = now;
                    score.setText("Score: "+f.score);
                }
            }
        };
        timer.start();


        scene.setOnKeyPressed(e-> {
            if(e.getCode().equals(KeyCode.UP) && f.snake.getDirection() !=Block.DOWN){
                f.snake.setDirection(Block.UP);
            }
            if(e.getCode().equals(KeyCode.DOWN) && f.snake.getDirection() !=Block.UP){
                f.snake.setDirection(Block.DOWN);
            }
            if(e.getCode().equals(KeyCode.RIGHT) && f.snake.getDirection() !=Block.LEFT){
                f.snake.setDirection(Block.RIGHT);
            }
            if(e.getCode().equals(KeyCode.LEFT) && f.snake.getDirection() !=Block.RIGHT){
                f.snake.setDirection(Block.LEFT);
            }
        });

        saveGame = new Button();
        saveGame.setPrefSize(150, 15);
        saveGame.setText("Save Game");
        saveGame.setFont(new Font("Arial",14));
        saveGame.setOnAction(e->{
            System.out.println("Game saved");
        });
        saveGame.setPadding(new Insets(12));
        saveGame.setLayoutX(520);
        saveGame.setLayoutY(30);

        Rectangle r = new Rectangle(25,25,650,50);
        r.setFill(Color.GRAY);

        root.getChildren().addAll(imageView);
        root.getChildren().add(r);
        root.getChildren().add(saveGame);
        root.getChildren().addAll(f, score);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
