package com.sazails.readJoinpoint.model;

public class Account {

    private String username;
    private int score;

    public Account() {}

    public Account(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
