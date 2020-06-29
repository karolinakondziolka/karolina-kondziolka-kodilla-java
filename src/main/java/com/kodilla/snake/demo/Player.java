package com.kodilla.snake.demo;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player> {
    private final String playerName;
    private final int playerScore;
    static List<Player> playerHighScores = new ArrayList<>();


    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public static void displayPlayerHighScores() {
        Collections.sort(playerHighScores, Collections.reverseOrder());
        for (int i = 0; i < playerHighScores.size(); i++) {
            System.out.println((i + 1) + ": " + playerHighScores.get(i));
        }
    }

    public static List<Player> getPlayersHighScores() {
        Collections.sort(playerHighScores, Collections.reverseOrder());
        return playerHighScores;
    }

    public static void addPlayerToHighScores(Player p) {
        playerHighScores.add(p);
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
    public int compareTo(Player player) {
        return (Integer.compare(this.getPlayerScore(), player.getPlayerScore()));
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