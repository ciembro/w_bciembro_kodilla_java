package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Symbol> moves = new ArrayList<>();
    private final String name;
    private int numOfWonRounds;
    private int roundScore;
    private int totalScore;

    public Player(String name) {
        this.name = name;
        this.numOfWonRounds = 0;
        this.roundScore = 0;
        this.totalScore = 0;
    }

    public List<Symbol> getMoves() {
        return new ArrayList<>(moves);
    }

    public int getNumOfWonRounds() {
        return numOfWonRounds;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void updateTotalScore(){
        totalScore++;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    Symbol move(Symbol symbol){
        moves.add(symbol);
        return symbol;
    }

    public void updateWonRounds(){
        numOfWonRounds++;
    }
}
