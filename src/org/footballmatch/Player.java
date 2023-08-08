package org.footballmatch;

public class Player {
    private int jerseyNumber;
    private String name;
    private int age;
    private String position;
    private int ability;
    private int goalsScored;
    private int timesPassed;

    public Player(int jerseyNumber, String name, int age, String position, int ability) {
        this.jerseyNumber = jerseyNumber;
        this.name = name;
        this.age = age;
        this.position = position;
        this.ability = ability;
        this.goalsScored = 0;
        this.timesPassed = 0;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getAbility() {
        return ability;
    }

    public void scoreGoal() {
        goalsScored++;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void pass() {
        timesPassed++;
    }

    public int getTimesPassed() {
        return timesPassed;
    }
}
