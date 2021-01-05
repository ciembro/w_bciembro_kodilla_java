package com.kodilla.rps;

import java.util.HashMap;

public class Rock extends Symbol {

    public Rock(){
        super(1, "rock");
        tableOfWins.put(1, 2);
        tableOfWins.put(2, 3);
        tableOfWins.put(3, 1);
    }

    public HashMap<Integer, Integer> getTableOfWins(){
        return new HashMap<>(tableOfWins);
    }



}
