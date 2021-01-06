package com.kodilla.rps;

import java.util.HashMap;
//HashMap<Integer, Integer> tabOfWins
//1 - win   //rock
//2 -draw   //paper
//3 - lost  //scissors

public abstract class Symbol {
    private final int id;
    private final String name;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (getId() != symbol.getId()) return false;
        return getName().equals(symbol.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
