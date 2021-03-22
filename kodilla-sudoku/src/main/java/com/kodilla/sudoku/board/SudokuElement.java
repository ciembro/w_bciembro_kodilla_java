package com.kodilla.sudoku.board;

import java.util.*;

public class SudokuElement implements Cloneable{

    public static final int EMPTY = -1;
    private int value;
    private List<Integer> possibleValues;

    public SudokuElement() {
        value = EMPTY;
        possibleValues = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void removeValue(int value){
        possibleValues.remove((Integer) value);
    }

    public boolean hasOnlyOnePossibleDigit(){
        return possibleValues.size() == 1;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public int guessValue(){
        return possibleValues.size() == 0 ? -1 : possibleValues.get(0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement that = (SudokuElement) o;

        if (getValue() != that.getValue()) return false;
        return getPossibleValues().equals(that.getPossibleValues());
    }

    @Override
    public int hashCode() {
        int result = getValue();
        result = 31 * result + getPossibleValues().hashCode();
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SudokuElement clonedElement = (SudokuElement) super.clone();
        clonedElement.possibleValues = new ArrayList<>();
        for(Integer v : this.possibleValues){
            clonedElement.possibleValues.add(v);
        }
        return clonedElement;
    }
}
