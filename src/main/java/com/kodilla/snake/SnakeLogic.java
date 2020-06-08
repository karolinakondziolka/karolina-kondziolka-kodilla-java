//package com.kodilla.snake;
//
//import com.sun.javafx.scene.traversal.Direction;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.stage.Stage;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class SnakeLogic extends Application {
//
//    static int speed = 5;
//    static int width = 20;
//    static int height = 20;
//    static int foodX = 0;
//    static int foodY = 0;
//    static Random randomFood = new Random();
//    static int cornerSize = 25;
//    static int score= 0;
//    static String highScore = "";
//    static Direction direction = Direction.LEFT;
//    static boolean gameOver = false;
//
//
//    public class Points {
//        int x;
//        int y;
//
//        public Points(int x, int y){
//            this.x=x;
//            this.y=y;
//        }
//    }
//
//    List<Points> snake = new ArrayList<>();
//
//    @Override
//    public void start(Stage stage1) throws Exception {
//
//        newFood();
//        Group root = new Group();
//        final Canvas canvas = new Canvas(650, 575); //obraz ktory bedzie rysowany przy uzyciu graficznych komend Graphiccontext
//        GraphicsContext gc = canvas.getGraphicsContext2D(); //uzywana do wstawaiania obrazow do Canvas przy uzyciu buffera
//        root.getChildren().add(canvas);
//
//        new AnimationTimer() { //tworzy timer, ktory jest wywolywany w"ramce" za kazdym razem gdy jest aktywny
//            long timer = 0;
//
//            @Override
//            public void handle(long now) {
//
//                if (timer == 0) {
//                    timer = now;
//                    move();
//                    addSnakeCorpus();
//                    if (highScore.equals("")) {
//                        highScore = this.GetHighScore();
//                    }
//                    destroySelf();
//                    draw(gc);
//                    return;
//                }
//                if (now - timer > 1000000000 / snakeSpeed + 1000000000) {
//                    timer = now;
//                    move();
//                    addSnakeCorpus();
//                    if (highScore.equals("")) {
//                        highScore = this.GetHighScore();
//                    }
//                    destroySelf();
//                    draw(gc);
//
//                }
//            }
//
//            private String GetHighScore() {
//
//                FileReader readFile = null;
//                BufferedReader reader = null;
//                // Format Luca:20
//                try {
//                    readFile = new FileReader("highscore.dat");
//                    reader = new BufferedReader(readFile);
//                    return reader.readLine();
//                } catch (Exception e) {
//                    return "Noone:0";
//                } finally {
//
//                    try {
//                        if (reader != null)
//                            reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//        SnakeCorpusAtBeginning();
//        Scene scene = new Scene(root, width * cornersize, height * cornersize, Color.DARKGRAY);
//        scene.addEventFilter(KeyEvent.KEY_PRESSED, (EventHandler<KeyEvent>) key -> {
//            final KeyCode code = key.getCode();
//
//            switch (code) {
//                case UP:
//                    if (move != Direction.down) {
//                        move = Direction.up;
//                    } else
//                        move = Direction.down;
//                    break;
//                case DOWN:
//                    if (move != Direction.up) {
//                        move = Direction.down;
//                    } else
//                        move = Direction.up;
//                    break;
//                case LEFT:
//                    if (move != Direction.right) {
//                        move = Direction.left;
//                    } else
//                        move = Direction.right;
//                    break;
//                case RIGHT:
//                    if (move != Direction.left) {
//                        move = Direction.right;
//                    } else
//                        move = Direction.left;
//                    break;
//            }
//        });
//        stage1.setTitle("SnakeGame");
//        stage1.setScene(scene);
//        stage1.show();
//    }
//
//    public void SnakeCorpusAtBeginning() {
//        snake.add(new Points(width / 2, height / 2));
//        snake.add(new Points((width / 2) - 1, height / 2));
//        snake.add(new Points((width / 2) - 2, height / 2));
//    }
//
//    private void move() {
//
//        for (int i = snake.size() - 1; i >= 1; i--) {
//            snake.get(i).x = snake.get(i - 1).x;
//            snake.get(i).y = snake.get(i - 1).y;
//        }
//        switch (move) {
//            case up:
//                snake.get(0).y--;
//                if (snake.get(0).y < 0) {
//                    isGameOver = true;
//                }
//                break;
//            case down:
//                snake.get(0).y++;
//                if (snake.get(0).y > height) {
//                    isGameOver = true;
//                }
//                break;
//            case left:
//                snake.get(0).x--;
//                if (snake.get(0).x < 0) {
//                    isGameOver = true;
//                }
//                break;
//            case right:
//                snake.get(0).x++;
//                if (snake.get(0).x > width) {
//                    isGameOver = true;
//                }
//                break;
//        }
//    }
//
//    private void addSnakeCorpus() {
//        if (appleX == snake.get(0).x && appleY == snake.get(0).y) {
//            snake.add(new Points(-1, -1));
//            score = snake.size() - 3;
//            Apple();
//        }
//    }
//
//    private void CheckScore() {
//        System.out.println(highScore);
//        if (highScore.equals(" "))
//            return;
//        if (score > Integer.parseInt(highScore.split(":")[1])) {
//            String name = JOptionPane.showInputDialog("You set new high score. What is your name ?");
//            highScore = name + ":" + (snake.size() - 3);
//
//            File scoreFile = new File("highscore.dat");
//            if (!scoreFile.exists()) {
//                try {
//                    scoreFile.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            FileWriter writeFile = null;
//            BufferedWriter write = null;
//
//            try {
//                writeFile = new FileWriter(scoreFile);
//                write = new BufferedWriter(writeFile);
//                write.write(this.highScore);
//            } catch (Exception e) {
//                // error
//            } finally {
//                try {
//                    if (write != null) {
//                        write.close();
//                    }
//                } catch (IOException e) {
//                    //  e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//    public void destroySelf() {
//        for (int i = 1; i < snake.size(); i++) {
//            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
//                isGameOver = true;
//            }
//        }
//    }
//
//    private void draw(GraphicsContext gc) {
//
//        if (isGameOver) {
//            gc.setFill(Color.CADETBLUE);
//            CheckScore();
//            gc.setFont(new Font("Verdana", 40));
//            gc.fillText("Game is over", 100, 40);
//            return;
//        }
//        // background
//        gc.setFill(Color.BLACK);
//        gc.fillRect(0, 0, width * cornersize, height * cornersize);
//
//        // Score and HighScore
//        gc.setFill(Color.GREEN);
//        gc.setFont(new Font("Verdana", 15));
//        gc.fillText("Score: " + score, 10, 20);
//        gc.fillText("HighScore: " + highScore, 10, 40);
//
//        //Apple
//        Color apple = Color.CORAL;
//        gc.setFill(apple);
//        gc.fillOval(appleX * cornersize, appleY * cornersize, cornersize, cornersize);
//
//        //Snake color
//        for (Points e : snake) {
//            gc.setFill(Color.YELLOW);
//            gc.fillRect(e.x * cornersize, e.y * cornersize, cornersize - 1, cornersize - 1);
//            gc.setFill(Color.YELLOWGREEN);
//            gc.fillRect(e.x * cornersize, e.y * cornersize, cornersize - 2, cornersize - 2);
//        }
//    }
//
//
//    private void Apple() {
//        start:
//        while (true) {
//            appleX = randApple.nextInt(width);
//            appleY = randApple.nextInt(height);
//            for (Points e : snake) {
//                if (e.x == appleX && e.y == appleY) {
//                    continue start;
//                }
//            }
//            snakeSpeed++;
//            break;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//
//}
//
//
