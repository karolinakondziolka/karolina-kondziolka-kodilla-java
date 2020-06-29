package com.kodilla.snake;

import com.kodilla.snake.demo.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;





public class Menu extends Application {
    private Button newGame;
    private Button loadGame;
    private Button savedGame;
    private Button scores;


    public static void main(String[] args) {
        launch(args);
    }

        public void start(Stage primaryStage) throws Exception {

            Image image = new Image("background.jpeg");
            ImageView imageView = new ImageView(image);

            Group root = new Group();
            newGame = new Button();
            newGame.setPrefSize(150, 15);
            newGame.setText("New Game");
            newGame.setFont(new Font("Arial",14));
            newGame.setOnAction(

                    event -> {
//                        Platform.runLater(() -> Main.restart());
                    });
            newGame.setPadding(new Insets(12));
            newGame.setLayoutX(275);
            newGame.setLayoutY(100);
            loadGame = new Button();
            loadGame.setPrefSize(150, 15);
            loadGame.setText("Load Game");
            loadGame.setFont(new Font("Arial",14));
            loadGame.setOnAction(e->{
                System.out.println("Load saved game");
            });
            loadGame.setPadding(new Insets(12));
            loadGame.setLayoutX(275);
            loadGame.setLayoutY(200);
            savedGame = new Button();
            savedGame.setPrefSize(150, 15);
            savedGame.setText("Saved Games");
            savedGame.setFont(new Font("Arial",14));
            savedGame.setOnAction(e->{
                System.out.println("List");
            });
            savedGame.setPadding(new Insets(12));
            savedGame.setLayoutX(275);
            savedGame.setLayoutY(300);
            scores = new Button();
            scores.setPrefSize(150, 15);
            scores.setText("Scores");
            scores.setFont(new Font("Arial",14));
            scores.setOnAction(e-> {
                        System.out.println("Best scores");
            });
            scores.setPadding(new Insets(12));
            scores.setLayoutX(275);
            scores.setLayoutY(400);

            Scene scene = new Scene(root, 700, 700);

            root.getChildren().add(imageView);
            root.getChildren().add(newGame);
            root.getChildren().add(loadGame);
            root.getChildren().add(savedGame);
            root.getChildren().add(scores);

            primaryStage.setTitle("Snake Menu");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        }

}
