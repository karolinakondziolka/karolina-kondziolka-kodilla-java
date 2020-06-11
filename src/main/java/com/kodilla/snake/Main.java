package com.kodilla.snake;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Button saveGame;

    static int blockSize = 15;
    int width = 80;
    int height = 50;
    int il = 4;
    long then = System.nanoTime();


    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, 700, 700);
        Field f = new Field(width, height);
        f.addSnake(new Snake(il, f));

        Image image = new Image("background.jpeg");
        ImageView imageView = new ImageView(image);



        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (now - then > 1000000000 / 8) {
                    f.update();
                    then = now;
                }
            }
        };
    timer.start();


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
        root.getChildren().add(f);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
