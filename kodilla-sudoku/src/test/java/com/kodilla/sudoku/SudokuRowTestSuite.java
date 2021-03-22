package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuRowTestSuite {

    private SudokuRow sudokuRow = new SudokuRow();

    @Test
    void testIsAlreadyInRow(){
        //given
        setRowData();
        //when&then
        assertTrue(sudokuRow.isAlreadyInFragment(sudokuRow.getElement(0), 7));
    }

    @Test
    void testIsPossibleInAnotherPlace(){
        //given
        setRowData();
        //when&then
        assertTrue(sudokuRow.isPossibleInAnotherPlace(sudokuRow.getElement(0), 5));
    }

    @Test
    void testGetEmptyElementIdx(){
        //given
        setRowData();
        //when
        int idx = sudokuRow.findEmptyElemColIdx();
        //then
        assertEquals(2, idx);
    }

    private void setRowData(){
        SudokuElement elementIdx0 = sudokuRow.getElement(0);
        SudokuElement elementIdx1 = sudokuRow.getElement(1);

        elementIdx0.setValue(5);
        elementIdx1.setValue(7);
    }
}
