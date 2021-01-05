package com.kodilla.rps;

import java.util.HashMap;

public class Scissors extends Symbol{

    public Scissors(){
        super(2, "scissors");
        tableOfWins.put(1, 3);
        tableOfWins.put(2, 1);
        tableOfWins.put(3, 2);
    }

    public HashMap<Integer, Integer> getTableOfWins(){
        return new HashMap<>(tableOfWins);
    }
}
