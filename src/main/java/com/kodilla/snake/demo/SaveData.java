package com.kodilla.snake.demo;

public class SaveData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public String playerName;
    public int playerHighScores;

    public SaveData(String playerName, int playerHighScores) {
        this.playerName = playerName;
        this.playerHighScores = playerHighScores;
    }

    public SaveData() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHighScores() {
        return playerHighScores;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerHighScores(int playerNighScores) {
        this.playerHighScores = playerHighScores;
    }
}
