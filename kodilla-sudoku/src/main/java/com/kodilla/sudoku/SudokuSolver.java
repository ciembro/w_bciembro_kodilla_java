package com.kodilla.sudoku;

import com.kodilla.sudoku.board.*;
import java.util.Iterator;

public class SudokuSolver {

    private SudokuBoard sudokuBoard;
    private SudokuBacktrack backtrack;

    public SudokuSolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void solve() throws InvalidSudokuException {

        while (!sudokuBoard.allPlacesFilled()){
            if (!iterateThroughRows() && !iterateThroughColumns() && !iterateThroughRegions()){
                try {
                    guessValue();
                } catch (CloneNotSupportedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean solveFragment(SudokuFragment fragment) throws InvalidSudokuException{
        boolean wasModified = false;
        for (SudokuElement element : fragment.getElements()){
            if (element.getValue() == SudokuElement.EMPTY){
                boolean wasProcessed = processElement(fragment, element);
                if (!wasModified){
                    wasModified = wasProcessed;
                }
            }
        }
        return wasModified;
    }

    private boolean iterateThroughRows() throws InvalidSudokuException{
        boolean wasModified = false;
        for (SudokuRow row : sudokuBoard.getRows()) {
            boolean wasProcessed = solveFragment(row);
            if (!wasModified){
                wasModified = wasProcessed;
           }
       }
        return wasModified;
    }

    private boolean iterateThroughColumns() throws InvalidSudokuException{
        boolean wasModified = false;
        SudokuColumn column;
        for (int i = 0; i < SudokuBoard.BOARD_SIZE; i++) {
            column = new SudokuColumn();
            column.createColumn(sudokuBoard, i);
            boolean wasProcessed = solveFragment(column);
            if (!wasModified) {
                wasModified = wasProcessed;
            }
        }
        return wasModified;
    }

    private boolean iterateThroughRegions() throws InvalidSudokuException{
        boolean wasModified = false;

        int initColIdx = 0;
        SudokuRegion region = new SudokuRegion();
        for (int i = 0; i < SudokuBoard.BOARD_SIZE/3; i++){
            for (int rowIdx = 0; rowIdx < SudokuBoard.BOARD_SIZE; rowIdx++){
                for (int colIdx = initColIdx; colIdx < initColIdx + 3; colIdx++){
                    SudokuElement element = sudokuBoard.getRows()
                            .get(rowIdx)
                            .getElement(colIdx);
                    region.getElements().add(element);
                }
                if ((rowIdx + 1) % 3 == 0){
                    boolean wasProcessed = solveFragment(region);
                    region = new SudokuRegion();
                    if (!wasModified) {
                        wasModified = wasProcessed;
                    }
                }
            }
            initColIdx += 3;
        }
        return wasModified;
    }

    private boolean processElement (SudokuFragment fragment, SudokuElement element) throws InvalidSudokuException {
        boolean wasModified = false;
        boolean clearPossibleValues = false;
        for (Iterator<Integer> i = element.getPossibleValues().iterator(); i.hasNext();){
            Integer possibleValue = i.next();
            if (fragment.isAlreadyInFragment(element, possibleValue)){
                i.remove();
                if (element.hasOnlyOnePossibleDigit()){
                    element.setValue(element.getPossibleValues().get(0));
                    clearPossibleValues = true;
                    break;
                }
                wasModified = true;
            } else if (!fragment.isPossibleInAnotherPlace(element, possibleValue)){
               element.setValue(possibleValue);
               i.remove();
               clearPossibleValues = true;
               wasModified = true;
               break;

            } else if (fragment.isPossibleInAnotherPlace(element, possibleValue) && element.hasOnlyOnePossibleDigit()){
                if (backtrack != null){
                    restoreBacktrack();
                } else{
                    throw new InvalidSudokuException();
                }
                break;
            }
        }
        if (clearPossibleValues){
            element.getPossibleValues().clear();
        }
        return wasModified;
    }

    private void guessValue() throws CloneNotSupportedException{
        int rowIdx = sudokuBoard.findEmptyElemRowIdx();
        if(rowIdx != -1) {
            int colIdx = sudokuBoard.getRows().get(rowIdx).findEmptyElemColIdx();
            if (colIdx != -1) {
                SudokuElement emptyElem = sudokuBoard.getRows().get(rowIdx).getElement(colIdx);
                int guessedValue = emptyElem.guessValue();
                if (guessedValue != -1) {
                    SudokuBoard boardToCopy = sudokuBoard.deepCopy();
                    backtrack = new SudokuBacktrack(boardToCopy, rowIdx, colIdx, guessedValue);
                    emptyElem.setValue(guessedValue);
                    emptyElem.getPossibleValues().clear();
                }
            }
        }
    }

    private void restoreBacktrack(){
        sudokuBoard = backtrack.getBoard();
        int valueToRemove = backtrack.getGuessedValue();
        sudokuBoard.getRows().get(backtrack.getRowIdx())
                .getElement(backtrack.getColIdx()).removeValue(valueToRemove);
    }

}
