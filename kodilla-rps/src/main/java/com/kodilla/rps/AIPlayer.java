package com.kodilla.rps;

import java.util.HashMap;
import java.util.Random;

public class AIPlayer extends Player {
    HashMap<Integer, Symbol> possibleMoves = new HashMap<>();

    public AIPlayer(){
        super();
        possibleMoves.put(1, new Rock());
        possibleMoves.put(2, new Paper());
        possibleMoves.put(3, new Scissors());
    }

    Symbol move() {
        Random random = new Random();
        int move = random.nextInt(3) + 1;
        if (move == 1) {
            return possibleMoves.get(1);
        }
        if (move == 2){
            return possibleMoves.get(2);
        }
        return possibleMoves.get(3);
    }
}
