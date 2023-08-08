package org.footballmatch;

import java.util.Random;
import java.util.List;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private Random random;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.random = new Random();
    }

    public void printDraft() {
        System.out.println(" --------- Ομάδα εντός έδρας: " + homeTeam.getName() + " ---------");
        homeTeam.printTeam();
        System.out.println("\n --------- Ομάδα εκτός έδρας: " + awayTeam.getName() + " ---------");
        awayTeam.printTeam();
    }

    public void startGame() {
        System.out.println("\n----- Ο αγώνας ξεκίνησε! -----");
        for (int i = 1; i <= 2; i++) {
            System.out.println("\n----- Ημίχρονο " + i + " -----");
            for (int j = 0; j < 10; j++) {
                offense(homeTeam, awayTeam);
                offense(awayTeam, homeTeam);
            }
        }
    }

    private void offense(Team attackingTeam, Team defendingTeam) {
        Player attacker = getRandomPlayer(attackingTeam, "attacker");
        Player defender = getRandomPlayer(defendingTeam, "defender");

        System.out.println("\n" + attackingTeam.getName() + " επιτίθεται!");

        if (attacker.getAbility() > defender.getAbility()) {
            defender.pass();
            Player goalkeeper = defendingTeam.getPlayerByPosition("goalkeeper");
            if (attacker.getAbility() > goalkeeper.getAbility()) {
                System.out.println(attacker.getName() + " σκοράρει!");
                attacker.scoreGoal();
                if (attackingTeam == homeTeam) {
                    homeScore++;
                } else {
                    awayScore++;
                }
            } else {
                System.out.println(goalkeeper.getName() + " σώζει το γκολ!");
            }
        } else {
            System.out.println(defender.getName() + " κόβει την επίθεση!");
        }
    }

    private Player getRandomPlayer(Team team, String position) {
        List<Player> players = team.getPlayersByPosition(position);
        int index = random.nextInt(players.size());
        return players.get(index);
    }
    
    public void printResults() {
        System.out.println("\n----- Λήξη αγώνα! -----");
        System.out.println("Τελικό σκορ: " + homeTeam.getName() + " " + homeScore + " - " + awayScore + " " + awayTeam.getName());
    }

    public void printBestOffencePlayerDetails(Player player) {
        if (player != null) {
            System.out.println("Όνομα: " + player.getName());
            System.out.println("Συνολικά γκολ: " + player.getGoalsScored());
        } else {
            System.out.println("Δεν βρέθηκε καλύτερος επιθετικός");
        }
    }

    public void printWorstDefencePlayerDetails(Player player) {
        if (player != null) {
            System.out.println("Όνομα: " + player.getName());
            System.out.println("Φορές που δεν αμύνθηκε σωστά: " + player.getTimesPassed());
        } else {
            System.out.println("Δεν βρέθηκε χειρότερος αμυντικός");
        }
    }
    
    public void printBestOffencePlayers() {
        Player homeTeamBestOffencePlayer = homeTeam.getBestOffencePlayer();
        Player awayTeamBestOffencePlayer = awayTeam.getBestOffencePlayer();

        System.out.println("\n----- Καλύτερος επιθετικός - " + homeTeam.getName() + " -----");
        printBestOffencePlayerDetails(homeTeamBestOffencePlayer);
        System.out.println("\n----- Καλύτερος επιθετικός - " + awayTeam.getName() + " -----");
        printBestOffencePlayerDetails(awayTeamBestOffencePlayer);
    }

    public void printWorstDefencePlayers() {
        Player homeTeamWorstDefencePlayer = homeTeam.getWorstDefencePlayer();
        Player awayTeamWorstDefencePlayer = awayTeam.getWorstDefencePlayer();

        System.out.println("\n----- Χειρότερος αμυντικός - " + homeTeam.getName() + " -----");
        printWorstDefencePlayerDetails(homeTeamWorstDefencePlayer);
        System.out.println("\n----- Χειρότερος αμυντικός - " + awayTeam.getName() + " -----");
        printWorstDefencePlayerDetails(awayTeamWorstDefencePlayer);
    }
}
