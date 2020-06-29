package com.kodilla.snake.demo;

import java.io.Serializable;

public class PlayerToSave implements Serializable {

    private String playerName;
    private int playerHighScore;

    public PlayerToSave(String playerName, int playerHighScore) {
        this.playerName = playerName;
        this.playerHighScore = playerHighScore;
    }

    public PlayerToSave() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHighScore() {
        return playerHighScore;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerHighScore(int playerHighScore) {
        this.playerHighScore = playerHighScore;
    }
}
