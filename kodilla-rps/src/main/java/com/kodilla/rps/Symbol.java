package com.kodilla.rps;

import java.util.HashMap;
//HashMap<Integer, Integer> tabOfWins
//1 - win   //rock
//2 -draw   //paper
//3 - lost  //scissors

public abstract class Symbol {
    final int id;
    final String name;
    HashMap<Integer, Integer> tableOfWins = new HashMap<>();

    public Symbol(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract HashMap<Integer, Integer> getTableOfWins();
}
