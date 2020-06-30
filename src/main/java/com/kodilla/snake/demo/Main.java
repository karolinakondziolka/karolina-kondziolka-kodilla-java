package com.kodilla.snake.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    private static final String name = "player";
    static int block_size = 20;
    //    int scoreValue = 0;
    int width = 30, height = 26;
    int il = 4;
    long then = System.nanoTime();
    boolean changed = false;
    int nextUpdate;
    boolean hasNext = false;
    private Button newGame;
    private Button loadGame;
    private Button saveGame;
    private Button scores;
    Field f;
    String playerName = "Player";
    Group root = new Group();
    Label score = new Label("Score: ");
    Gson gson = new Gson();
    Scene scene = new Scene(root, 650, 650);
    ImageView imageView = new ImageView(new Image("background.jpeg"));
    Rectangle r = new Rectangle(25, 25, 600, 50);
    Player player = new Player(name, 0);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ps) {

        r.setFill(Color.GRAY);
        root.getChildren().addAll(imageView, r);

        f = new Field(width, height);
        f.addSnake(new Snake(il, f));

        score.setFont(Font.font("Arial", 20));
        score.setLayoutX(40);
        score.setLayoutY(40);

//        Player.playerHighScores = loadData();

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (now - then > 1000000000 / f.speed) {
                    f.update();
                    then = now;
                    score.setText("Score: " + f.score);
                    changed = false;
                    if (hasNext) {
                        setDirection(f.snake, nextUpdate);
                        hasNext = false;
                    }
                }
                if (f.isDead()) {
                    stop();

                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("GAME OVER");
                    al.setContentText("Your score is: " + f.score + "\n" + "Would you like to play again?");
                    Platform.runLater(al::showAndWait);
                    displayGameOverMessage();
                    al.setOnHiding(e -> {
                        root.getChildren().clear();
                        f = new Field(width, height);
                        f.addSnake(new Snake(il, f));
                        score.setText("Score: 0");
                        root.getChildren().addAll(imageView, r, score, newGame, saveGame, loadGame, f, scores);
                        start();
                    });
                }
            }
        };
        timer.start();

        root.getChildren().addAll(f, score);

        scene.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.UP) && f.snake.getDirection() != Block.DOWN) {
                setDirection(f.snake, Block.UP);
            }
            if (e.getCode().equals(KeyCode.DOWN) && f.snake.getDirection() != Block.UP) {
                setDirection(f.snake, Block.DOWN);
            }
            if (e.getCode().equals(KeyCode.RIGHT) && f.snake.getDirection() != Block.LEFT) {
                setDirection(f.snake, Block.RIGHT);
            }
            if (e.getCode().equals(KeyCode.LEFT) && f.snake.getDirection() != Block.RIGHT) {
                setDirection(f.snake, Block.LEFT);
            }
        });

        newGame = new Button();
        newGame.setPrefSize(100, 15);
        newGame.setText("New Game");
        newGame.setFont(new Font("Arial", 14));
        newGame.setOnAction(
                event -> {
                    cleanUp();
                    start(ps);
                });
        newGame.setPadding(new Insets(12));
        newGame.setLayoutX(190);
        newGame.setLayoutY(30);

        saveGame = new Button();
        saveGame.setPrefSize(100, 15);
        saveGame.setText("Save Game");
        saveGame.setFont(new Font("Arial", 14));
        saveGame.setOnAction(e -> {
            saveData();
        });

        saveGame.setPadding(new Insets(12));
        saveGame.setLayoutX(300);
        saveGame.setLayoutY(30);

        loadGame = new Button();
        loadGame.setPrefSize(100, 15);
        loadGame.setText("Load Game");
        loadGame.setFont(new Font("Arial", 14));
        loadGame.setOnAction(event -> {
            loadData();
        });
        loadGame.setPadding(new Insets(12));
        loadGame.setLayoutX(410);
        loadGame.setLayoutY(30);

        scores = new Button();
        scores.setPrefSize(100, 15);
        scores.setText("Scores");
        scores.setFont(new Font("Arial", 14));
        scores.setOnAction(event -> {
            player.getPlayerScore();
        });
        scores.setPadding(new Insets(12));
        scores.setLayoutX(520);
        scores.setLayoutY(30);

        root.getChildren().addAll(newGame, loadGame, saveGame, scores);

        ps.setResizable(false);
        ps.setScene(scene);
        ps.setTitle("Snake Game");
        ps.show();
    }

    private void cleanUp() {
        root.getChildren().clear();
        f = new Field(width, height);
        f.addSnake(new Snake(il, f));
        score.setText("Score: 0");
        player = new Player(name, 0);
    }
//    private void addPlayerToHighScores() {
//        Player player = new Player(playerName, scoreValue);
//        Player.addPlayerToHighScores(player);
//    }

    public void setDirection(Snake s, int d) {
        if (!changed) {
            s.setDirection(d);
            changed = true;
        } else {
            hasNext = true;
            nextUpdate = d;
        }
    }

    private void saveData() {

        try {
            Writer writer = new FileWriter("snakeHighScoresList.json");

            new Gson().toJson(player, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant find file " + e);
        }
    }

    private List<Player> loadData() {
        Gson gson = new Gson();
        List<Player> listFromJson = new ArrayList<>();
        try (Reader reader = new FileReader("snakeHighScoresList.json")) {
            Type playerListType = new TypeToken<ArrayList<Player>>() {
            }.getType();
            listFromJson = gson.fromJson(reader, playerListType);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant find file " + e);
        }
        return listFromJson;
    }

    private void displayGameOverMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game over ");
        sb.append(playerName);
        sb.append(", you score is: ");
        sb.append(f.score);
        sb.append("\n");
        sb.append("HighScores:");
        System.out.println(sb);

        player.getPlayerScore();
    }
}