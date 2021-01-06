package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public class TableOfWins {

    Map<Symbol, Symbol> wins = new HashMap<>();

    public TableOfWins(){
        wins.put(new Rock(), new Scissors());  //rock beats scissors
        wins.put(new Paper(), new Rock());  //paper beats rock
        wins.put(new Scissors(), new Paper()); //scissors beats paper
    }

    public Map<Symbol, Symbol> getWins() {
        return new HashMap<>(wins);
    }
}
