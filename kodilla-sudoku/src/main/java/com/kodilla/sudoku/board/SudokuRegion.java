package com.kodilla.sudoku.board;

public class SudokuRegion extends SudokuFragment {

    @Override
    public String toString() {
        String tab = "reg: ";
        for (SudokuElement element : elements) {
            tab += element.getValue() + " ";
        }
        return tab;
    }
}
