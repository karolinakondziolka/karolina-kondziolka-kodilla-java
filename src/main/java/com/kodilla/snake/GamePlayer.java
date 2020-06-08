package com.kodilla.snake;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GamePlayer extends Application {

    private Button saveGame;

    static int blockSize = 10;
    int width = 40;
    int height = 30;
    int initialLength = 3;


    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 700, 700);
        Field f= new Field(width, height);
        f.addSnakeClass(new SnakeClass(initialLength, f));

        Image image = new Image("background.jpeg");
//        Image title = new Image("snaketitle.jpg");
        ImageView imageView = new ImageView(image);
//        ImageView titleView = new ImageView(title);


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
        Rectangle r1 = new Rectangle(25,100,650,575);
        r1.setFill(Color.BLACK);

        root.getChildren().addAll(imageView);
        root.getChildren().add(r);
        root.getChildren().add(r1);
        root.getChildren().add(saveGame);
        root.getChildren().add(f);
//        root.getChildren().add(titleView);
        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();



    }
}
