package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SudokuSolverTestSuite {

    private SudokuBoard board;
    private SudokuSolver sudokuSolver;

    @Test
    void testSolveValidSudoku(){
        //given
        setValidSudoku();
        System.out.println("valid sudoku to solve");
        System.out.println(board);
        //when&then
        try {
            SudokuBoard resultBoard = sudokuSolver.solve();
            System.out.println(resultBoard);
        } catch (InvalidSudokuException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testInvalidSudoku(){
        //given
        setInvalidSudoku();
        System.out.println("invalid sudoku to solve");
        System.out.println(board);
        //when&then
        assertThrows(InvalidSudokuException.class, () ->sudokuSolver.solve());
    }

    private void setValidSudoku(){
        board = new SudokuBoard();
        UserValuesDto userValuesDto = new UserValuesDto(2,1,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,1,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,2,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,1,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,1,3);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(8,1,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,2,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(5,2,9);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,2,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,2,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,2,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,3,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(1,4,3);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(2,4,5);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(5,4,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,4,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(8,4,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(2,5,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,5,1);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,6,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,6,9);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,6,1);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(2,7,9);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(4,7,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,7,5);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(8,7,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,7,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(1,8,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,8,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,8,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(1,9,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(2,9,3);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,9,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(4,9,9);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(5,9,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,9,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,9,5);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(9,9,6);
        board.updateBoard(userValuesDto);

        sudokuSolver = new SudokuSolver(board);
    }

    private void setInvalidSudoku(){
        board = new SudokuBoard();

        UserValuesDto userValuesDto = new UserValuesDto(2,1,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,1,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,2,6);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(7,1,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(8,1,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,2,8);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(4,2,1);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(1,2,2);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(5,2,4);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(6,2,7);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(2,2,3);
        board.updateBoard(userValuesDto);
        userValuesDto = new UserValuesDto(3,2,5);
        board.updateBoard(userValuesDto);

        sudokuSolver = new SudokuSolver(board);
    }

}
