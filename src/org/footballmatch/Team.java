package org.footballmatch;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void printTeam() {
        for (Player player : players) {
            System.out.println("Αριθμός Φανέλας: " + player.getJerseyNumber());
            System.out.println("Όνομα: " + player.getName());
            System.out.println("Ηλικία: " + player.getAge());
            System.out.println("Θέση: " + player.getPosition());
            System.out.println("Ικανότητα: " + player.getAbility());
            System.out.println("--------------------");
        }
    }
    
    public Player getPlayerByPosition(String position) {
        for (Player player : players) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                return player;
            }
        }
        return null;
    }
    
    public List<Player> getPlayersByPosition(String position) {
        List<Player> playersByPosition = new ArrayList<>();
        for (Player player : players) {
            if (player.getPosition().equalsIgnoreCase(position)) {
                playersByPosition.add(player);
            }
        }
        return playersByPosition;
    }
    
    public Player getBestOffencePlayer() {
        Player bestOffencePlayer = null;
        int maxGoals = -1;

        for (Player player : players) {
            if (player.getPosition().equals("attacker") && player.getGoalsScored() > maxGoals) {
                maxGoals = player.getGoalsScored();
                bestOffencePlayer = player;
            }
        }

        return bestOffencePlayer;
    }

    public Player getWorstDefencePlayer() {
        Player worstDefencePlayer = null;
        int maxTimesPassed = -1;

        for (Player player : players) {
            if (player.getPosition().equals("defender") && player.getTimesPassed() > maxTimesPassed) {
                maxTimesPassed = player.getTimesPassed();
                worstDefencePlayer = player;
            }
        }
        return worstDefencePlayer;
    }
}

