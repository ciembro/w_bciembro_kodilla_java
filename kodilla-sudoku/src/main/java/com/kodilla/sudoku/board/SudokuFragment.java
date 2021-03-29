package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SudokuFragment {

    protected List<SudokuElement> elements = new ArrayList<>();

    public SudokuFragment() {}

    public List<SudokuElement> getElements() {
        return elements;
    }

    public SudokuElement getElement(int idx){
        return elements.get(idx);
    }

    public boolean isAlreadyInFragment(SudokuElement element, int digit){
        for (SudokuElement currentElement : elements) {
            if (element != currentElement && currentElement.getValue() == digit) {
                return true;
            }
        }
        return false;
    }

    public boolean isPossibleInAnotherPlace(SudokuElement element, int digit){
        for (SudokuElement currentElement : elements){
            if (element != currentElement && currentElement.getPossibleValues().contains(digit)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (SudokuElement e : elements){
            s+= e.getValue() + " ";
        }
        return s;


    }
}
