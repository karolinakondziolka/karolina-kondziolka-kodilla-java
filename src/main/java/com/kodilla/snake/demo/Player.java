package com.kodilla.snake.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private String playerName;
    private int playerScore;


    public List<PlayerInfo> playersHighScores = new ArrayList<>();

    public Player(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;

    }

    public void clearHighScores(){
        playersHighScores.clear();
    }

    public void addPoints(int number) {
        this.playerScore += number;
    }

    public void setPoints(int number){
        this.playerScore = number;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    public void addPlayerToHighScores(PlayerInfo player) {
        if(playerName.equals(player.name)){
            playersHighScores.add(player);
        }

    }
    public List<PlayerInfo> getPlayersHighScores() {
        return playersHighScores;
    }
    public void displayPlayerHighScores() {
        for (int i = 0; i < playersHighScores.size(); i++) {
            System.out.println( playersHighScores.get(i).score);
        }
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
        return "Player: " + playerName + "    " + "Score: " + playerScore;
    }

}