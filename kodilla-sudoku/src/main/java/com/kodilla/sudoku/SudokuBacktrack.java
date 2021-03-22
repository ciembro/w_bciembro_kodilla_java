package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;

public class SudokuBacktrack {

    private final SudokuBoard board;
    private final int rowIdx;
    private final int colIdx;
    private final int guessedValue;

    public SudokuBacktrack(final SudokuBoard board, final int rowIdx, final int colIdx, final int value) {
        this.board = board;
        this.rowIdx = rowIdx;
        this.colIdx = colIdx;
        this.guessedValue = value;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getColIdx() {
        return colIdx;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
