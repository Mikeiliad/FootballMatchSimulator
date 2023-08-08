package org.footballmatch;

public class Main {
    public static void main(String[] args) {
        Team homeTeam = new Team("Axastoi");
        homeTeam.addPlayer(new Player(1, "Nikopolidis", 32, "goalkeeper", 80));
        homeTeam.addPlayer(new Player(2, "Georgiou", 19, "defender", 55));
        homeTeam.addPlayer(new Player(3, "Prelevic", 32, "defender", 70));
        homeTeam.addPlayer(new Player(4, "Georgevits", 32, "defender", 87));
        homeTeam.addPlayer(new Player(5, "Chalkias", 25, "defender", 72));
        homeTeam.addPlayer(new Player(6, "Nikou", 23, "defender", 65));
        homeTeam.addPlayer(new Player(7, "Katsouranis", 21, "attacker", 80));
        homeTeam.addPlayer(new Player(8, "Mpismpikis", 21, "attacker", 78));
        homeTeam.addPlayer(new Player(9, "Tzortzoglou", 29, "attacker", 82));
        homeTeam.addPlayer(new Player(10, "Mystridis", 30, "attacker", 60));
        homeTeam.addPlayer(new Player(11, "Messi", 33, "attacker", 76));

        Team awayTeam = new Team("Anikitoi");
        awayTeam.addPlayer(new Player(1, "Georgiadis", 30, "goalkeeper", 77));
        awayTeam.addPlayer(new Player(2, "Adonis", 31, "defender", 75));
        awayTeam.addPlayer(new Player(3, "Mitsotakis", 22, "defender", 73));
        awayTeam.addPlayer(new Player(4, "Koutsoumpas", 25, "defender", 70));
        awayTeam.addPlayer(new Player(5, "Arnaoutoglou", 25, "defender", 85));
        awayTeam.addPlayer(new Player(6, "Light", 29, "defender", 59));
        awayTeam.addPlayer(new Player(7, "Snik", 21, "attacker", 77));
        awayTeam.addPlayer(new Player(8, "Ubuntoglou", 31, "attacker", 81));
        awayTeam.addPlayer(new Player(9, "Cook", 22, "attacker", 79));
        awayTeam.addPlayer(new Player(10, "Musk", 34, "attacker", 59));
        awayTeam.addPlayer(new Player(11, "Gates", 27, "attacker", 54));

        Match match = new Match(homeTeam, awayTeam);

        match.printDraft();

        match.startGame();

        match.printResults();

        match.printBestOffencePlayers();

        match.printWorstDefencePlayers();
    }
}
