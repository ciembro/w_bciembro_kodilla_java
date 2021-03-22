package com.kodilla.sudoku.board;


public class SudokuColumn extends SudokuFragment {

    public void createColumn(SudokuBoard sudokuBoard, int colIdx) {
        for (SudokuRow row : sudokuBoard.getRows()) {
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
