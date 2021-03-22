package com.kodilla.sudoku.board;

import com.kodilla.sudoku.Prototype;
import com.kodilla.sudoku.UserValuesDto;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype<SudokuBoard> {


    public static final int BOARD_SIZE = 9;
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0 ; i < BOARD_SIZE; i++){
            rows.add(new SudokuRow());
        }
    }

    public void updateBoard(UserValuesDto userValuesDto){
       SudokuRow sudokuRow = rows.get(userValuesDto.getRow() - 1);
       SudokuElement sudokuElement = sudokuRow.getElement(userValuesDto.getColumn() - 1);
       sudokuElement.setValue(userValuesDto.getValue());
       sudokuElement.getPossibleValues().clear();
    }

    public boolean allPlacesFilled(){
        for (SudokuRow row : rows){
            for (SudokuElement element : row.getElements()){
                if (element.getValue() == SudokuElement.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public int findEmptyElemRowIdx(){
        for (int i = 0; i < SudokuBoard.BOARD_SIZE; i++) {
            if (rows.get(i).findEmptyElemColIdx() != -1){
                return i;
            }
        }
        return -1;
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = shallowCopy();
        clonedBoard.rows = new ArrayList<>();
        for (SudokuRow row : rows){
            SudokuRow clonedRow = new SudokuRow();
            List<SudokuElement> clonedElements = new ArrayList<>();
            for (SudokuElement element : row.getElements()){
                clonedElements.add((SudokuElement)element.clone());
            }
            clonedRow.elements = clonedElements;
            clonedBoard.getRows().add(clonedRow);

        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        String rowSeparator = "|------ | ------ | ------ | \n";
        String board = rowSeparator;
        int i = 0;
        for (SudokuRow row : rows){
            board += row.toString();
            if (i == 2 || i == 5 || i == 8){
                board += rowSeparator;
            }
            i++;
        }
        return board;
    }
}
