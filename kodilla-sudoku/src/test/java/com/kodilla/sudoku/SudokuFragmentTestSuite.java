package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuElement;
import com.kodilla.sudoku.board.SudokuRow;
import org.junit.jupiter.api.Test;

public class SudokuFragmentTestSuite {

    private SudokuBoard sudokuBoard = new SudokuBoard();

    @Test
    void testProcessElementWhenAlreadyInRow(){
        //given
        SudokuSolver solver = new SudokuSolver(sudokuBoard);
        SudokuRow row = sudokuBoard.getRows().get(0);
        SudokuElement element1 =  row.getElements().get(0);
        SudokuElement element2 = row.getElements().get(8);
        element1.setValue(1);
        element2.setValue(9);
        SudokuElement testedElement = row.getElements().get(1);
        //when
//        solver.solve();



    }
}
