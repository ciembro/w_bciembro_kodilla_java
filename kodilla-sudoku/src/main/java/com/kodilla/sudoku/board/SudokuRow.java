package com.kodilla.sudoku.board;

public class SudokuRow extends SudokuFragment {

    public SudokuRow() {
        for (int i = 0; i < SudokuBoard.BOARD_SIZE; i++){
            elements.add(new SudokuElement());
        }
    }

    public int findEmptyElemColIdx(){
        for (int i = 0; i < SudokuBoard.BOARD_SIZE; i++) {
            SudokuElement currentElement = elements.get(i);
            if (currentElement.getValue() == SudokuElement.EMPTY){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String row = "| ";
        for (int i = 0; i < SudokuBoard.BOARD_SIZE; i++){
            row += getElement(i).getValue() + " ";
            if (i == 2 || i == 5 || i == 8){
                row += "|  ";
            }
        }
        row += "\n";
        return row;
    }
}
