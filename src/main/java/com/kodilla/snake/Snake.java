//package com.kodilla.snake;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import java.util.Random;
//
//
//public class Snake extends Application {
//
//    private Button saveGame;
//
//    public void start(Stage stage1) {
//
//        Image image = new Image("background.jpeg");
////        Image title = new Image("snaketitle.jpg");
//        ImageView imageView = new ImageView(image);
////        ImageView titleView = new ImageView(title);
//        Group root = new Group();
//        Scene scene = new Scene(root, 700, 700);
//
//        saveGame = new Button();
//        saveGame.setPrefSize(150, 15);
//        saveGame.setText("Save Game");
//        saveGame.setFont(new Font("Arial",14));
//        saveGame.setOnAction(e->{
//            System.out.println("Game saved");
//        });
//        saveGame.setPadding(new Insets(12));
//        saveGame.setLayoutX(520);
//        saveGame.setLayoutY(30);
//
//        Rectangle r = new Rectangle(25,25,650,50);
//        r.setFill(Color.GRAY);
//        Rectangle r1 = new Rectangle(25,100,650,575);
//        r1.setFill(Color.BLACK);
//
//        root.getChildren().addAll(imageView);
//        root.getChildren().add(r);
//        root.getChildren().add(r1);
//        root.getChildren().add(saveGame);
////        root.getChildren().add(titleView);
//        stage1.setTitle("Snake");
//        stage1.setScene(scene);
//        stage1.setResizable(false);
//        stage1.show();
//
//    }
//
//}
