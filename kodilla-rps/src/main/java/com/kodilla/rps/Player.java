package com.kodilla.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private List<Symbol> moves = new ArrayList<>();
    private int wonRounds;

    public Player() {
        this.wonRounds = 0;
    }

    public List<Symbol> getMoves() {
        return new ArrayList<>(moves);
    }

    public int getWonRounds() {
        return wonRounds;
    }

    void move(Symbol symbol){
        moves.add(symbol);
    }

    public void updateWonRounds(){
        wonRounds++;
    }
}
