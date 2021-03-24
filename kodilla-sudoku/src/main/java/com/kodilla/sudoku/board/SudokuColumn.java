package com.kodilla.sudoku.board;


public class SudokuColumn extends SudokuFragment {

    public void createColumn(SudokuBoard board, int colIdx) {
        for (SudokuRow row : board.getRows()) {
            SudokuElement elem = row.getElement(colIdx);
            elements.add(elem);
        }
    }

    @Override
    public String toString() {
        String tab = "col: ";
        for (SudokuElement element : elements) {
            tab += element.getValue() + " ";
        }
        return tab;
    }
}
