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

    private static final String name = "Gracz";
    static int block_size = 20;
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
    Label score = new Label("Score: 0");
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

        f = new Field(width, height, player);
        f.addSnake(new Snake(il, f));

        score.setFont(Font.font("Arial", 20));
        score.setLayoutX(40);
        score.setLayoutY(40);


        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (now - then > 1000000000 / f.speed) {
                    f.update();
                    then = now;
                    score.setText("Score: " + player.getPlayerScore());
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
                    al.setContentText("Your score is: " + player.getPlayerScore() + "\n" + "Would you like to play again?");
                    Platform.runLater(al::showAndWait);
                    saveData();
                    displayGameOverMessage();
                    al.setOnHiding(e -> {
                        root.getChildren().clear();
                        player.setPoints(0);
                        f = new Field(width, height, player);
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
            player.getPlayerScore();
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
            System.out.println("Best scores:");
            loadData();
            player.displayPlayerHighScores();
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
        player.setPoints(0);
        f = new Field(width, height, player);
        f.addSnake(new Snake(il, f));
        score.setText("Score: 0");
        player = new Player(name, f.score);
    }

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
            List<PlayerInfo> listFromJson = new ArrayList<>();
            try (Reader reader = new FileReader("snakeHighScoresList.json")) {
                Type playerListType = new TypeToken<List<PlayerInfo>>() {
                }.getType();
                listFromJson = gson.fromJson(reader, playerListType);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cant find file " + e);
            }

            Writer writer = new FileWriter("snakeHighScoresList.json");
            PlayerInfo playerInfo = new PlayerInfo(player.getPlayerName(), player.getPlayerScore());
            listFromJson.add(playerInfo);
            new Gson().toJson(listFromJson, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant find file " + e);
        }
    }

    private void loadData() {

        Gson gson = new Gson();

        List<PlayerInfo> listFromJson = new ArrayList<>();
        try (Reader reader = new FileReader("snakeHighScoresList.json")) {
            Type playerListType = new TypeToken<List<PlayerInfo>>(){}.getType();
            listFromJson = gson.fromJson(reader, playerListType);
            player.clearHighScores();
            for(int i=0; i<listFromJson.size(); i++){
                player.addPlayerToHighScores(listFromJson.get(i));
            }
            int index = listFromJson.size()-1;
            PlayerInfo playerInfo = listFromJson.get(index);
            int score = playerInfo.score;
            player.setPoints(score);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cant find file " + e);
        }
    }

    private void displayGameOverMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game over ");
        sb.append(playerName);
        sb.append(", you score is: ");
        sb.append(player.getPlayerScore());
        sb.append("\n");
        sb.append("HighScores:");
        System.out.println(sb);
        loadData();
        player.displayPlayerHighScores();
    }
}