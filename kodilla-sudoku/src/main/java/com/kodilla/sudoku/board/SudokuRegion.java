package com.kodilla.sudoku.board;

public class SudokuRegion extends SudokuFragment {

    public void createRegion(SudokuBoard board, int initRowIdx, int initColIdx){
        for (int rowIdx = initRowIdx; rowIdx < initRowIdx + 3; rowIdx++){
            for (int colIdx = initColIdx; colIdx < initColIdx + 3; colIdx++){
                SudokuElement element = board.getRows()
                        .get(rowIdx)
                        .getElement(colIdx);
                elements.add(element);
            }
        }
    }

    @Override
    public String toString() {
        String tab = "reg: ";
        for (SudokuElement element : elements) {
            tab += element.getValue() + " ";
        }
        return tab;
    }
}
