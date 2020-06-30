package com.kodilla.snake.demo;


import java.io.Serializable;

public class Player implements Serializable {
    private String playerName;
    private int playerScore;

    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;

    }

    public int addPoints() {
        playerScore += 10;
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        System.out.println(playerScore);
        return playerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (playerScore != player.playerScore) return false;
        return playerName != null ? playerName.equals(player.playerName) : player.playerName == null;
    }

    @Override
    public int hashCode() {
        int result = playerName != null ? playerName.hashCode() : 0;
        result = 31 * result + playerScore;
        return result;
    }

    @Override
    public String toString() {
        return "Player: " + playerName + " --- " + "Score: " + playerScore;
    }
}