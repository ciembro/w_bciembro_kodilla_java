package com.kodilla.rps;

import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer() {
        super("Imaginary friend");
    }

    Symbol move() {
        int move = drawSymbol();
        if (move == 1) {
            return move(new Rock());
        }
        if (move == 2) {
            return move(new Paper());
        }
        return move(new Scissors());
    }

    int drawSymbol(){
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

}
