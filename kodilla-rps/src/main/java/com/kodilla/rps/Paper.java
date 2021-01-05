package com.kodilla.rps;

import java.util.HashMap;

public class Paper extends Symbol {

    public Paper(){
        super(2, "paper");
        tableOfWins.put(1, 1);
        tableOfWins.put(2, 2);
        tableOfWins.put(3, 3);
    }

    public HashMap<Integer, Integer> getTableOfWins(){
        return new HashMap<>(tableOfWins);
    }
}
