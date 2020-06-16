package com.kodilla.snake.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    private Button saveGame;

    static int block_size = 10;
    int width=65, height=57;
    int il = 5;

    long then =System.nanoTime();

    boolean changed = false;
    int nextUpdate;
    boolean hasNext = false;

    Field f;

    @Override
    public void start(Stage ps) {
        Group root = new Group();
        Scene scene = new Scene(root, 700, 700);

        Image image = new Image("background.jpeg");
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);
        Rectangle r = new Rectangle(25, 25, 650, 50);
        r.setFill(Color.GRAY);
        root.getChildren().add(r);


        f = new Field(width, height);
        f.addSnake(new Snake(il,f));

        Label score = new Label("Score: 0");
        score.setFont(Font.font("Arial", 20));
        score.setLayoutX(40);
        score.setLayoutY(40);



        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (now - then > 1000000000 / 8) {
                    f.update();
                    then = now;
                    score.setText("Score: " + f.score);
                    changed = false;
                    if (hasNext) {
                        setDirection(f.snake, nextUpdate);
                        hasNext = false;
                    }

                    if (f.isDead()) {
                        stop();

                        Alert al = new Alert(Alert.AlertType.WARNING);
                        al.setHeaderText("GAME OVER");
                        al.setContentText("Your score is: " + f.score);
                        Platform.runLater(al::showAndWait);
                        al.setOnHiding(e -> {
                            root.getChildren().clear();
                            f = new Field(width, height);
                            f.addSnake(new Snake(il, f));
                            score.setText("Score: 0");

                            root.getChildren().addAll(f, score);
                            start();

                        });


                    }
                }

            }

        };
        timer.start();

        root.getChildren().addAll(f, score);


        scene.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.UP) && f.snake.getDirection() !=Block.DOWN){
                setDirection(f.snake, Block.UP);
            }
            if(e.getCode().equals(KeyCode.DOWN) && f.snake.getDirection() !=Block.UP){
                setDirection(f.snake, Block.DOWN);
            }
            if(e.getCode().equals(KeyCode.RIGHT) && f.snake.getDirection() !=Block.LEFT){
                setDirection(f.snake, Block.RIGHT);
            }
            if(e.getCode().equals(KeyCode.LEFT) && f.snake.getDirection() !=Block.RIGHT){
                setDirection(f.snake,Block.LEFT);
            }
        });

        saveGame = new Button();
        saveGame.setPrefSize(150, 15);
        saveGame.setText("Save Game");
        saveGame.setFont(new Font("Arial", 14));
        saveGame.setOnAction(e -> {
            System.out.println("Game saved");
        });
        saveGame.setPadding(new Insets(12));
        saveGame.setLayoutX(520);
        saveGame.setLayoutY(30);

        root.getChildren().add(saveGame);

        ps.setResizable(false);
        ps.setScene(scene);
        ps.setTitle("Snake Game");
        ps.show();

    }

    public void setDirection(Snake s, int d){
        if(!changed) {
            s.setDirection(d);
            changed = true;
        }else{
            hasNext = true;
            nextUpdate = d;
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
