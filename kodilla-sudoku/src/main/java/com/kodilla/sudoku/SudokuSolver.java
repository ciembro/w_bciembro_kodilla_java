package com.kodilla.sudoku;

import com.kodilla.sudoku.board.*;

import java.util.*;

public class SudokuSolver {

    public SudokuBoard sudokuBoard;
    private final Deque<SudokuBacktrack> backtrackStack = new ArrayDeque<>();

    public SudokuSolver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard solve() throws InvalidSudokuException {
        while (!sudokuBoard.allPlacesFilled()){
            if (!iterateThroughRows() && !iterateThroughColumns() && !iterateThroughRegions()){
                try {
                    guessValue();
                } catch (CloneNotSupportedException e){
                    e.printStackTrace();
                }
            }
        }
        return sudokuBoard;
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

    public boolean iterateThroughRegions() throws InvalidSudokuException{
        boolean wasModified = false;

        int colIdx = 0;
        int rowIdx = 0;
        while (colIdx < 9){
            SudokuRegion region = new SudokuRegion();
            region.createRegion(sudokuBoard, rowIdx, colIdx);
            boolean wasProcessed = solveFragment(region);
            if (!wasModified) {
                wasModified = wasProcessed;
            }
            rowIdx += 3;
            if (rowIdx >= SudokuBoard.BOARD_SIZE){
                rowIdx = 0;
                colIdx += 3;
            }
        }
        return wasModified;
    }

    private boolean processElement (SudokuFragment fragment, SudokuElement element) throws InvalidSudokuException {
        boolean wasModified = false;
        boolean clearPossibleValues = false;
        for (Iterator<Integer> i = element.getPossibleValues().iterator(); i.hasNext();){
            Integer possibleValue = i.next();
            if (element.hasOnlyOnePossibleDigit()){
                if (!fragment.isAlreadyInFragment(element, possibleValue)){
                    element.setValue(possibleValue);
                    i.remove();
                    wasModified = true;
                } else {
                    if (!backtrackStack.isEmpty()){
                        restoreBacktrack();
                    } else {
                        throw new InvalidSudokuException();
                    }
                }
            } else if (fragment.isAlreadyInFragment(element, possibleValue)){
                i.remove();
                wasModified = true;
            } else if (!fragment.isPossibleInAnotherPlace(element, possibleValue)){
                element.setValue(possibleValue);
                i.remove();
                clearPossibleValues = true;
                wasModified = true;
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
                    SudokuBacktrack backtrack = new SudokuBacktrack(boardToCopy, rowIdx, colIdx, guessedValue);
                    backtrackStack.push(backtrack);
                    emptyElem.setValue(guessedValue);
                    emptyElem.getPossibleValues().clear();
                }
            }
        }
    }

    private void restoreBacktrack() throws InvalidSudokuException{
        SudokuBacktrack backtrack = backtrackStack.pop();
        sudokuBoard = backtrack.getBoard();
        int valueToRemove = backtrack.getGuessedValue();
        SudokuElement elementToUpdate = sudokuBoard.getRows().get(backtrack.getRowIdx())
                .getElement(backtrack.getColIdx());
        elementToUpdate.removeFromPossibleValues(valueToRemove);

        if (elementToUpdate.getPossibleValues().size() == 0){
            throw new InvalidSudokuException();
        }
    }
}
